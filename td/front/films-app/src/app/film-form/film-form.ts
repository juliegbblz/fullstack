import { Component, inject, input, signal, effect } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { FilmService } from '../film-service';
import { ActeurService } from '../acteur-service';
import { Film } from '../film.model';
import { Acteur } from '../acteur.model';

@Component({
  selector: 'app-film-form',
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './film-form.html',
  styleUrl: './film-form.css'
})
export class FilmForm {
  private filmService = inject(FilmService);
  private acteurService = inject(ActeurService);
  private router = inject(Router);

  id = input<string>();

  titre = signal<string>('');
  realisateur = signal<string>('');
  genre = signal<string>('');
  dateSortie = signal<string>('');
  
  tousLesActeurs = signal<Acteur[]>([]);
  acteursDuFilm = signal<Acteur[]>([]);
  
  isEditMode = signal<boolean>(false);
  erreur = signal<string>('');

  constructor() {
    this.acteurService.getAll().subscribe({
      next: (acteurs) => this.tousLesActeurs.set(acteurs),
      error: () => this.erreur.set("Impossible de charger la liste des acteurs.")
    });

    effect(() => {
      const filmId = this.id();
      if (filmId) {
        this.isEditMode.set(true);
        this.filmService.getById(Number(filmId)).subscribe({
          next: (film) => {
            this.titre.set(film.titre || '');
            this.realisateur.set(film.realisateur || '');
            this.genre.set(film.genre || '');
            this.dateSortie.set(film.dateSortie);
            if (film.acteurs) {
              this.acteursDuFilm.set(film.acteurs);
            }
          },
          error: () => this.erreur.set("Impossible de charger les informations du film.")
        });
      }
    });
  }

  onSubmit() {
    const filmData: Partial<Film> = {
      titre: this.titre(),
      realisateur: this.realisateur(),
      genre: this.genre(),
      dateSortie: this.dateSortie()
    };

    if (this.isEditMode() && this.id()) {
      this.filmService.modifier(Number(this.id()), filmData as Film).subscribe({
        next: () => this.router.navigate(['/films', this.id()]),
        error: (err) => this.erreur.set(err.message)
      });
    } else {
      this.filmService.creer(filmData).subscribe({
        next: () => this.router.navigate(['/films']),
        error: (err) => this.erreur.set(err.message)
      });
    }
  }
}