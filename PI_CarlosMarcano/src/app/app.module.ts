import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { LogoComponent } from './components/header/logo/logo.component';
import { BannerComponent } from './components/header/banner/banner.component';
import { RedesComponent } from './components/header/redes/redes.component';
import { YoProgramoComponent } from './components/header/yo-programo/yo-programo.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LogoComponent,
    BannerComponent,
    RedesComponent,
    YoProgramoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
