import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/models/modeloPersona';
import { PersonaService } from 'src/app/services/persona.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-acercade',
  templateUrl: './acercade.component.html',
  styleUrls: ['./acercade.component.css']
})
export class AcercadeComponent implements OnInit {
  persona: Persona = new Persona("", "", "", "", "");

  constructor(public personaService: PersonaService, private tokenService: TokenService) { }

  isLogged = false;
  
  ngOnInit(): void {
    this.cargarPersona();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }

  cargarPersona(): void{
    this.personaService.detalle(1).subscribe({
      next: data => { this.persona = data }
    });
  }
}
