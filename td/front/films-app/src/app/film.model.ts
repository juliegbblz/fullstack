import { Acteur } from "./acteur.model";

export interface Film {
genre: any;
id: number;
titre: string;
realisateur: string;
dateSortie: Date;
acteurs?: Acteur[];
}