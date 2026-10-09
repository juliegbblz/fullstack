import { Service, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Film } from './film.model'; // Assurez-vous que le chemin correspond à votre interface

@Service()
export class FilmService {
  private http = inject(HttpClient);
  
  private url = '/api/films';

  getAll(): Observable<Film[]> {
    return this.http.get<Film[]>(this.url);
  }

  getById(id: number): Observable<Film> {
    return this.http.get<Film>(`${this.url}/${id}`);
  }
}