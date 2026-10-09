import { Component, input, computed, inject, signal, effect } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ActeurService } from '../acteur-service';
import { FilmCard } from '../film-card/film-card';
import { Film } from '../film.model';

@Component({
  selector: 'app-acteur-detail',
  imports: [RouterLink, FilmCard],
  styleUrl: './acteur-detail.css',
  templateUrl: './acteur-detail.html',
})
export class ActeurDetail {
  id = input.required<string>();
  acteurId = computed(() => Number(this.id()));

  private service = inject(ActeurService);
  
  films = signal<Film[]>([]);
  acteurNom = signal<string>('Acteur');
  erreur = signal<string>('');

  constructor() {
    effect(() => {
      this.service.getFilmsByActeurId(this.acteurId()).subscribe({
        next: (f) => {
          this.films.set(f);
          this.erreur.set('');
        },
        error: (e) => {
          this.erreur.set(e.status === 404 ? "Acteur introuvable" : "Erreur serveur");
        }
      });

      this.service.getById(this.acteurId()).subscribe({
        next: (a) => {
          if (a && a.nom) {
            this.acteurNom.set(a.nom);
          }
        }
      });
    });
  }
}