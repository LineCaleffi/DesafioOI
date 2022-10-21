import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListarUsuariosComponent } from './listar-usuarios/listar-usuarios.component';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from '../shared/shared.module';
import { FormUsuariosComponent } from './form-usuarios/form-usuarios.component';
import { UsuariosRoutingModule } from './usuarios-routing.module';



@NgModule({
  declarations: [
    ListarUsuariosComponent,
    FormUsuariosComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    UsuariosRoutingModule,
    SharedModule
  ],
  exports:[
    ListarUsuariosComponent
  ]
})
export class UsuariosModule { }
