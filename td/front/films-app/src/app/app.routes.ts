import { Routes } from '@angular/router';
import { FilmList } from './film-list/film-list';
import { FilmDetail } from './film-detail/film-detail';
import { FilmForm } from './film-form/film-form';
import { ActeurList } from './acteur-list/acteur-list';
import { ActeurDetail } from './acteur-detail/acteur-detail';
import { ActeurForm } from './acteur-form/acteur-form';

export const routes: Routes = [
  
  { path: 'films', component: FilmList },
  { path: 'films/nouveau', component: FilmForm },
  { path: 'films/:id/modifier', component: FilmForm},
  { path: 'films/:id', component: FilmDetail },
  { path: 'films/:id/editer', component: FilmForm },

  { path: 'acteurs', component: ActeurList },
  { path: 'acteurs/:id', component: ActeurDetail },
  { path: 'acteur/nouveau', component: ActeurForm },

  { path: '', redirectTo: 'films', pathMatch: 'full' },
  
  { path: '**', redirectTo: 'NotFound' }
];