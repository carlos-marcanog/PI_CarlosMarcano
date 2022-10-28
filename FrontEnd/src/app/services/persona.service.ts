import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core"
import { Observable } from "rxjs";
import { Persona } from "../models/modeloPersona";

@Injectable({
	providedIn: 'root'
})
export class PersonaService {
	URL = 'http://localhost:8090/personas/';

	constructor(private http:HttpClient) {}

	public obtenerPersona(): Observable<Persona>{
		return this.http.get<Persona>(this.URL+'obtener/1');
	}
}
