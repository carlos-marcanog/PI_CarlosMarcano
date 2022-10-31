import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Experiencia } from '../models/modeloExperiencia';

@Injectable({
  providedIn: 'root'
})
export class ExperienciaService {
  URL = environment.URLDev + "experiencia/"

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Experiencia[]>{
    return this.httpClient.get<Experiencia[]>(this.URL + 'lista');
  }

  public detalle(id:number): Observable<Experiencia>{
    return this.httpClient.get<Experiencia>(this.URL + `detalle/${id}`);
  }

  public save(experiencia: Experiencia): Observable<any>{
    return this.httpClient.post<any>(this.URL + 'crear', experiencia);
  }

  public update(id:number, experiencia: Experiencia): Observable<any>{
    return this.httpClient.put<any>(this.URL + `editar/${id}`, experiencia)
  }

  public delete(id:number): Observable<any>{
    return this.httpClient.delete<any>(this.URL + `delete/${id}`);
  }
}
