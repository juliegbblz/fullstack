import { Component, inject } from '@angular/core';
import { AsyncPipe } from '@angular/common';
import { FilmService } from '../film-service';
import { FilmCard } from '../film-card/film-card';
import { Film } from '../film.model';

@Component({
  selector: 'app-film-list',
  imports: [AsyncPipe, FilmCard],
  templateUrl: './film-list.html',
  styleUrl: './film-list.css'
})
export class FilmList {
  private service = inject(FilmService);
  films$ = this.service.getAll();

  onSupprimer(film: Film) {
    if (confirm(`Voulez-vous vraiment supprimer le film "${film.titre}" ?`)) {
      this.service.supprimer(film.id).subscribe({
        next: () => {
          console.log("Suppression réussie !");
          this.films$ = this.service.getAll();
        },
        error: (err) => {
          console.error("Erreur lors de la suppression", err);
          alert("Impossible de supprimer ce film.");
        }
      });
    }
  }
}