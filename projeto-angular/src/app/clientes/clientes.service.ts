import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor(private httpCliente : HttpClient) { }

  getAll(){
    return this.httpCliente.get('http://localhost:8080/api/cliente')
  }

  getOne(id : number){
    return this.httpCliente.get(`http://localhost:8080/api/cliente/${id}`)
  }

  save(obj: ClientesService){
    return this.httpCliente.post('http://localhost:8080/api/cliente', obj);
  }

  delete(id : number){
    return this.httpCliente.delete(`http://localhost:8080/api/cliente/${id}`)
  }

  update(id:number,obj : any){
    return this.httpCliente.patch(`http://localhost:8080/api/cliente/${id}`, obj);
  }
}
