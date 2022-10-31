import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core"
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Persona } from "../models/modeloPersona";

@Injectable({
	providedIn: 'root'
})
export class PersonaService {
	URL = environment.URLDev + 'personas/';

	constructor(private httpClient: HttpClient) {}

	public lista(): Observable<Persona[]>{
    	return this.httpClient.get<Persona[]>(this.URL + 'lista');
  	}

  	public detalle(id:number): Observable<Persona>{
    	return this.httpClient.get<Persona>(this.URL + `detail/${id}`);
  	}

  	public update(id: number, persona: Persona): Observable<any>{
    	return this.httpClient.put<any>(this.URL + `update/${id}`, persona);
  	}

}
