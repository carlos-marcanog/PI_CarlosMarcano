import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { EditAcercadeComponent } from './components/main/acercade/edit-acercade.component';
import { EditarEducacionComponent } from './components/main/educacion/editar-educacion.component';
import { EditarExperienciaComponent } from './components/main/experiencia/editar-experiencia.component';
import { EditSkillsComponent } from './components/main/skills/hard/edit-skills.component';
import { EditSoftComponent } from './components/main/skills/soft/edit-soft.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'editexp/:id', component: EditarExperienciaComponent},
  {path:'editedu/:id', component: EditarEducacionComponent},
  {path:'editskill/:id', component: EditSkillsComponent},
  {path:'editsoft/:id', component: EditSoftComponent},
  {path:'editpersona/:id', component: EditAcercadeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
