import { Component, input, computed, inject, signal, effect } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FilmService } from '../film-service';
import { Film } from '../film.model';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-film-detail',
  imports: [RouterLink,DatePipe],
  templateUrl: './film-detail.html',
  styleUrl: './film-detail.css'
})
export class FilmDetail{
  id = input.required<string>();
  
  filmId = computed(() => Number(this.id()));

  private service = inject(FilmService);
  film = signal<Film | undefined>(undefined);
  erreur = signal<string>('');

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
    });
  }
}