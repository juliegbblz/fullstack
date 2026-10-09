import { Component, inject } from '@angular/core';
import { AsyncPipe } from '@angular/common';
import { RouterLink } from '@angular/router';
import { ActeurService } from '../acteur-service';

@Component({
  selector: 'app-acteur-list',
  imports: [AsyncPipe, RouterLink],
  templateUrl: './acteur-list.html',
  styleUrl: './acteur-list.css'
})
export class ActeurList {
  private service = inject(ActeurService);
  acteurs$ = this.service.getAll();
}