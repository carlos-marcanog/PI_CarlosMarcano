import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Experiencia } from 'src/app/models/modeloExperiencia';
import { ExperienciaService } from 'src/app/services/experiencia.service';

@Component({
  selector: 'app-new-experiencia',
  templateUrl: './new-experiencia.component.html',
  styleUrls: ['./new-experiencia.component.css']
})
export class NewExperienciaComponent implements OnInit {

  nombreExp: string = '';
  descripcionExp: string = '';
  cargo: string = '';
  fechaIngreso: string = '';
  fechaEgreso: string = '';

  constructor(private servicioExp: ExperienciaService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const exp = new Experiencia(this.nombreExp, this.descripcionExp, 
      this.cargo, this.fechaIngreso, this.fechaEgreso);
      this.servicioExp.save(exp).subscribe(data => {
      alert("Experiencia Agregada");
      window.location.reload();
    }, err =>{
      alert("Error al Agregar Experiencia");
      window.location.reload();
    });
  }

}
