import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { LogoComponent } from './components/header/logo/logo.component';
import { BannerComponent } from './components/main/banner/banner.component';
import { NavBarComponent } from './components/header/navbar/navbar.component';
import { MainComponent } from './components/main/main.component';
import { FooterComponent } from './components/footer/footer.component';
import { AcercadeComponent } from './components/main/acercade/acercade.component';
import { ExperienciaComponent } from './components/main/experiencia/experiencia.component';
import { EducacionComponent } from './components/main/educacion/educacion.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { SkillsComponent } from './components/main/skills/hard/skills.component';
import { ProyectosComponent } from './components/main/proyectos/proyectos.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { FormsModule } from '@angular/forms';
import { interceptorProvider } from './services/interceptor.service';
import { NewExperienciaComponent } from './components/main/experiencia/new-experiencia.component';
import { EditarExperienciaComponent } from './components/main/experiencia/editar-experiencia.component';
import { NeweducacionComponent } from './components/main/educacion/neweducacion.component';
import { EditarEducacionComponent } from './components/main/educacion/editar-educacion.component';
import { EditSkillsComponent } from './components/main/skills/hard/edit-skills.component';
import { NewSkillsComponent } from './components/main/skills/hard/new-skills.component';
import { SoftSkillsComponent } from './components/main/skills/soft/soft-skills.component';
import { NewSoftComponent } from './components/main/skills/soft/new-soft.component';
import { EditSoftComponent } from './components/main/skills/soft/edit-soft.component';
import { EditAcercadeComponent } from './components/main/acercade/edit-acercade.component';
import { EditProyectosComponent } from './components/main/proyectos/edit-proyectos.component';
import { NewProyectosComponent } from './components/main/proyectos/new-proyectos.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LogoComponent,
    BannerComponent,
    NavBarComponent,
    MainComponent,
    FooterComponent,
    AcercadeComponent,
    ExperienciaComponent,
    EducacionComponent,
    SkillsComponent,
    ProyectosComponent,
    LoginComponent,
    HomeComponent,
    NewExperienciaComponent,
    EditarExperienciaComponent,
    NeweducacionComponent,
    EditarEducacionComponent,
    EditSkillsComponent,
    NewSkillsComponent,
    SoftSkillsComponent,
    NewSoftComponent,
    EditSoftComponent,
    EditAcercadeComponent,
    EditProyectosComponent,
    NewProyectosComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgCircleProgressModule.forRoot({}),
    FormsModule
  ],
  providers: [
    { provide: interceptorProvider, useValue: undefined }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
