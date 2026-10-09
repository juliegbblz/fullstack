import { Component, input, output } from '@angular/core';
import { Film } from '../film.model';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-film-card',
  imports: [RouterLink],
  templateUrl: './film-card.html',
  styleUrl: './film-card.css'
})
export class FilmCard {
  
  film = input.required<Film>(); 
  
  supprimer = output<Film>();

  onSupprimer() {
    this.supprimer.emit(this.film());
  }
}