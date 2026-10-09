import { Service, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
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

  creer(f: Partial<Film>): Observable<Film> {
    return this.http.post<Film>(this.url, f).pipe(
      catchError(this.handleError)
    );
  }

  modifier(id: number, f: Film): Observable<Film> {
    return this.http.put<Film>(`${this.url}/${id}`, f).pipe(
      catchError(this.handleError)
    );
  }

  supprimer(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }

  associerActeur(filmId: number, acteurId: number): Observable<any> {
    return this.http.post(`${this.url}/${filmId}/acteurs/${acteurId}`, {}).pipe(
      catchError(this.handleError)
    );
  }

  dissocierActeur(filmId: number, acteurId: number): Observable<any> {
    return this.http.delete(`${this.url}/${filmId}/acteurs/${acteurId}`).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: any) {
    console.error('Une erreur est survenue sur le serveur :', error);
    return throwError(() => new Error('Erreur lors de la requête au serveur. Veuillez réessayer plus tard.'));
  }

}