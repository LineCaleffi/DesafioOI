import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListarClientesComponent } from './listar-clientes/listar-clientes.component';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from '../shared/shared.module';
import { ClientesRoutingModule } from './clientes-routing.module';
import { FormClientesComponent } from './form-clientes/form-clientes.component';



@NgModule({
  declarations: [
    ListarClientesComponent,
    FormClientesComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    SharedModule,
    ClientesRoutingModule
  ],
  exports:[
    ListarClientesComponent
  ]
})
export class ClientesModule { }
