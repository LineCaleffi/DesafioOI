import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormUsuariosComponent } from './form-usuarios/form-usuarios.component';
import { ListarUsuariosComponent } from './listar-usuarios/listar-usuarios.component';

const routes: Routes = [
  {path: 'usuarios', component: ListarUsuariosComponent},
  {path: 'usuarios/criar', component: FormUsuariosComponent},
  {path: 'usuarios/editar/:id', component: FormUsuariosComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsuariosRoutingModule { }
