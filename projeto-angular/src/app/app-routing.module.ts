import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ListarClientesComponent } from './clientes/listar-clientes/listar-clientes.component';
import { ListarProdutosComponent } from './produtos/listar-produtos/listar-produtos.component';
import { ListarUsuariosComponent } from './usuarios/listar-usuarios/listar-usuarios.component';


const routes: Routes = [
  {path: 'home', component: AppComponent},
  {path: 'clientes', component: ListarClientesComponent},
  {path: 'produtos', component: ListarProdutosComponent},
  {path: 'usuarios', component: ListarUsuariosComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
