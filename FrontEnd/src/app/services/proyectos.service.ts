import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Proyectos } from '../models/modeloProyectos';

@Injectable({
  providedIn: 'root'
})
export class ProyectosService {
  URL = environment.URLProd + "proyectos/"

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Proyectos[]>{
    return this.httpClient.get<Proyectos[]>(this.URL + 'lista');
  }

  public detalle(id:number): Observable<Proyectos>{
    return this.httpClient.get<Proyectos>(this.URL + `detalle/${id}`);
  }

  public save(proyectos: Proyectos): Observable<any>{
    return this.httpClient.post<any>(this.URL + 'crear', proyectos);
  }

  public update(id:number, proyectos: Proyectos): Observable<any>{
    return this.httpClient.put<any>(this.URL + `editar/${id}`, proyectos)
  }

  public delete(id:number): Observable<any>{
    return this.httpClient.delete<any>(this.URL + `delete/${id}`);
  }
}
