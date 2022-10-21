import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProdutosService } from '../produtos.service';

@Component({
  selector: 'app-listar-produtos',
  templateUrl: './listar-produtos.component.html',
  styleUrls: ['./listar-produtos.component.scss']
})
export class ListarProdutosComponent implements OnInit {
  produtos : any = [];

  constructor(private activatedRoute : ActivatedRoute, private produtoService : ProdutosService) { }

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
    this.produtoService.getAll()
    .subscribe(
      (data) => {
        console.log(data);
        this.produtos = data;
      }
    );
  }

  onDelete(id : number){
    this.produtoService.delete(id)
    .subscribe(
      ()=>{
        console.log(`deletou registro com id ${id}`);
         // retorna os dados do BD
        this.getAll();
      }
    );
  }

}
