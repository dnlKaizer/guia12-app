import { Routes } from '@angular/router';

import { HomeComponent } from './pages/home/home.component';
import { CadastrarFuncionarioComponent } from './pages/cadastrar-funcionario/cadastrar-funcionario.component';
import { ConsultarFuncionariosComponent } from './pages/consultar-funcionarios/consultar-funcionarios.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'cadastrar', component: CadastrarFuncionarioComponent },
  { path: 'cadastrar/:id', component: CadastrarFuncionarioComponent },
  { path: 'consultar', component: ConsultarFuncionariosComponent }
];
