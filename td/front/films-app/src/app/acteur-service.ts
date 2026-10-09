import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Acteur } from './acteur.model';

@Injectable({ providedIn: 'root' })
export class ActeurService {
  private http = inject(HttpClient);
  private url = '/api/acteurs'; // URL pointant vers le proxy[cite: 57]

  getAll(): Observable<Acteur[]> {
    return this.http.get<Acteur[]>(this.url);
  }
}