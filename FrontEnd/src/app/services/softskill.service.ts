import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Soft } from '../models/modeloSoft';

@Injectable({
  providedIn: 'root'
})
export class SoftskillService {

    URL = environment.URL + "softs/"
  constructor(private httpClient: HttpClient) { }

    public lista(): Observable<Soft[]>{
    return this.httpClient.get<Soft[]>(this.URL + 'lista');
  }

  public detail(id:number): Observable<Soft>{
    return this.httpClient.get<Soft>(this.URL + `detail/${id}`);
  }

  public save(soft: Soft): Observable<any>{
    return this.httpClient.post<any>(this.URL + 'create', soft);
  }

  public update(id: number, soft: Soft): Observable<any>{
    return this.httpClient.put<any>(this.URL + `edit/${id}`, soft)
  }

  public delete(id:number): Observable<any>{
    return this.httpClient.delete<any>(this.URL + `delete/${id}`);
  }
}
