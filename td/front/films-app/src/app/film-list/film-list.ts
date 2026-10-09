import { Component, inject } from '@angular/core';
import { AsyncPipe } from '@angular/common';
import { FilmService } from '../film-service';

@Component({
  selector: 'app-film-list',
  imports: [AsyncPipe],
  templateUrl: './film-list.html',
  styleUrl: './film-list.css'
})
export class FilmList {
  films$ = inject(FilmService).getAll(); 
}