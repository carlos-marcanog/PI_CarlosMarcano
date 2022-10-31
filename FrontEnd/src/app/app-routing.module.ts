import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { EditarEducacionComponent } from './components/main/educacion/editar-educacion.component';
import { EditarExperienciaComponent } from './components/main/experiencia/editar-experiencia.component';
import { NewExperienciaComponent } from './components/main/experiencia/new-experiencia.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'editexp/:id', component: EditarExperienciaComponent},
  {path:'editedu/:id', component: EditarEducacionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
