import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormClientesComponent } from './form-clientes/form-clientes.component';
import { ListarClientesComponent } from './listar-clientes/listar-clientes.component';

const routes: Routes = [
  {path: 'clientes', component: ListarClientesComponent},
  {path: 'clientes/criar', component: FormClientesComponent},
  {path: 'clientes/editar/:id', component: FormClientesComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientesRoutingModule { }
