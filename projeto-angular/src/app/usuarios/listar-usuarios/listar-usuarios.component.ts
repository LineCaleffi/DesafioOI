import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UsuariosService } from '../usuarios.service';

@Component({
  selector: 'app-listar-usuarios',
  templateUrl: './listar-usuarios.component.html',
  styleUrls: ['./listar-usuarios.component.scss']
})
export class ListarUsuariosComponent implements OnInit {

  usuarios : any = [];

  constructor(private activatedRoute : ActivatedRoute, private usuariosService : UsuariosService) { }

  ngOnInit(): void {
    this.getAll();

    this.activatedRoute.params.subscribe((data)=>{
      console.log(data);
    });
  }

  private getAll(){
    this.usuariosService.getAll().subscribe((data)=>{
      console.log(data);
      this.usuarios = data;
    });
  }

  onDelete(id:number){
    this.usuariosService.delete(id).subscribe(()=>{
      console.log(`deletou registro com id ${id}`);
      this.getAll();
    })
  }

}
