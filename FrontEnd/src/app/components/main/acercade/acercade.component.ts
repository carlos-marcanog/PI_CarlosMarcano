import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/models/modeloPersona';
import { PersonaService } from 'src/app/services/persona.service';

@Component({
  selector: 'app-acercade',
  templateUrl: './acercade.component.html',
  styleUrls: ['./acercade.component.css']
})
export class AcercadeComponent implements OnInit {
  persona: Persona = new Persona("", "", "");

  constructor(public personaService: PersonaService) { }

  ngOnInit(): void {
    this.personaService.obtenerPersona().subscribe(data => {
      this.persona = data
    });
  }

}
