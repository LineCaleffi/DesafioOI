import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProdutosService {

  constructor(private httpCliente : HttpClient) { }

  getAll(){
    return this.httpCliente.get('http://localhost:8080/api/produto')
  }

  getOne(id : number){
    return this.httpCliente.get(`http://localhost:8080/api/produto/${id}`)
  }

  save(obj : ProdutosService){
    return this.httpCliente.post(`http://localhost:8080/api/produto`, obj)
  }

  delete(id : number){
    return this.httpCliente.delete(`http://localhost:8080/api/produto/${id}`)
  }

  update(id:number,obj : any){
    return this.httpCliente.patch(`http://localhost:8080/api/produto/${id}`, obj);
  }
}
