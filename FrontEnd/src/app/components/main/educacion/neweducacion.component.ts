import { Component, OnInit } from '@angular/core';
import { Educacion } from 'src/app/models/modeloEducacion';
import { EducacionService } from 'src/app/services/educacion.service';

@Component({
  selector: 'app-neweducacion',
  templateUrl: './neweducacion.component.html',
  styleUrls: ['./neweducacion.component.css']
})
export class NeweducacionComponent implements OnInit {

  nombreEdu: string;
  ubicacion: string;
  anioEgreso: string;
  titulo: string;

  constructor(private servicioEducacion: EducacionService) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const educacion = new Educacion(this.nombreEdu, this.ubicacion, this.anioEgreso, this.titulo);
    this.servicioEducacion.save(educacion).subscribe({
      next: data => { alert("Educacion Creada"), window.location.reload(); }
    })
  }
}
