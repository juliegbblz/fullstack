import { Component, input, computed, inject, signal, effect } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FilmService } from '../film-service';
import { ActeurService } from '../acteur-service';
import { Film } from '../film.model';
import { Acteur } from '../acteur.model';
import { DatePipe } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-film-detail',
  imports: [RouterLink,FormsModule,DatePipe],
  templateUrl: './film-detail.html',
  styleUrl: './film-detail.css'
})
export class FilmDetail{
  id = input.required<string>();
  
  filmId = computed(() => Number(this.id()));

  private service = inject(FilmService);
  private acteurService = inject(ActeurService);
  film = signal<Film | undefined>(undefined);
  erreur = signal<string>('');
  acteurSelectionne = signal<number | null>(null);
  tousLesActeurs = signal<Acteur[]>([]);
  acteursDuFilm = signal<Acteur[]>([]);

  constructor() {
    effect(() => {
      this.service.getById(this.filmId()).subscribe({
        next: (f) => {
          this.film.set(f);
          this.erreur.set('');
        },
        error: (e) => {
          this.erreur.set(e.status === 404 ? "Film introuvable" : "Erreur serveur");
        }
      });

      this.acteurService.getAll().subscribe({
        next: (acteurs) => {
          this.tousLesActeurs.set(acteurs);
        },
        error: (err) => console.error("Erreur chargement acteurs :", err)
      });
    });
  }

  recharger() {
    this.service.getById(this.filmId()).subscribe({
      next: (f) => {
        this.film.set(f);
        this.erreur.set('');
      },
      error: (e) => {
        this.erreur.set(e.status === 404 ? "Film introuvable" : "Erreur serveur");
      }
    });
  }

  associer() {
    const id = this.acteurSelectionne();
    if (!id) return;
    
    this.service.associerActeur( this.filmId(), id)
      .subscribe({
        next: () => this.recharger(),
        error: () => this.erreur.set( "Association impossible" )
      });
  }

  dissocier(acteurId: number) {
    this.service.dissocierActeur(this.filmId(), acteurId).subscribe({
      next: () => this.recharger(),
      error: () => this.erreur.set("Dissociation impossible")
    });
  }
  
}