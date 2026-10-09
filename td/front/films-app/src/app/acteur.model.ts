import { Film } from "./film.model";

export interface Acteur {
  id: number;
  nom: string;
  films?: Film[];
}