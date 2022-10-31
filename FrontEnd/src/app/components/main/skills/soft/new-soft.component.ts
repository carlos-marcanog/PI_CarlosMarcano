import { Component, OnInit } from '@angular/core';
import { Soft } from 'src/app/models/modeloSoft';
import { SoftskillService } from 'src/app/services/softskill.service';

@Component({
  selector: 'app-new-soft',
  templateUrl: './new-soft.component.html',
  styleUrls: ['./new-soft.component.css']
})
export class NewSoftComponent implements OnInit {

  nombreSoft: string;
  porcentaje: number;

  constructor(private servicioSoft: SoftskillService) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const skill = new Soft(this.nombreSoft, this.porcentaje);
    this.servicioSoft.save(skill).subscribe({
      next: data => { alert("Soft Creada"), window.location.reload(); },
      error: err => { alert("Error al Crear Soft"), window.location.reload(); }
    });
  }
}
