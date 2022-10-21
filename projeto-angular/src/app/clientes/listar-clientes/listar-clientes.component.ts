import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ClientesService } from '../clientes.service';

@Component({
  selector: 'app-listar-clientes',
  templateUrl: './listar-clientes.component.html',
  styleUrls: ['./listar-clientes.component.scss']
})
export class ListarClientesComponent implements OnInit {
  clientes : any = [];

  constructor(private activatedRoute : ActivatedRoute, private clientesService : ClientesService) { }

  ngOnInit(): void {
    this.getAll();

    this.activatedRoute.params.subscribe(
      (data) => {
        console.log(data);
      }
    );
  }

  //pega os dados do BD
  private getAll(){
    this.clientesService.getAll()
    .subscribe(
      (data) => {
        console.log(data);
        this.clientes = data;
      }
    );
  }

  onDelete(id : number){
    this.clientesService.delete(id)
    .subscribe(
      ()=>{
        console.log(`deletou registro com id ${id}`);
         // retorna os dados do BD
        this.getAll();
      }
    );
  }

}
