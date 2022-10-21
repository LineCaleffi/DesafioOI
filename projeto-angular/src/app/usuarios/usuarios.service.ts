import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  constructor(private httpClient: HttpClient) { }

  getAll(){
    return this.httpClient.get('http://localhost:8080/api/usuario');
  }

  getOne(id: number){
    return this.httpClient.get(`http://localhost:8080/api/usuario/${id}`);
  }

  save(obj: UsuariosService){
    return this.httpClient.post('http://localhost:8080/api/usuario', obj);
  }

  update(id : number, obj : UsuariosService){
    return this.httpClient.patch(`http://localhost:8080/api/usuario/${id}`, obj);
  }

  delete(id:number){
    return this.httpClient.delete(`http://localhost:8080/api/usuario/${id}`);
  }
}
