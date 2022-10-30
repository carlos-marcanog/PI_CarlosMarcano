import { Component, OnInit } from '@angular/core';
import { Educacion } from 'src/app/models/modeloEducacion';
import { EducacionService } from 'src/app/services/educacion.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {

  edu: Educacion[] = [];
  
  constructor(private servicioEdu: EducacionService, private tokenService: TokenService) { }
  isLogged = false;

  ngOnInit(): void {
    this.cargarEduacion();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }

  cargarEduacion(): void{
    this.servicioEdu.lista().subscribe({
      next: data => { this.edu = data }
    });
  }

  delete(id?:number){
    if(id != undefined){
      this.servicioEdu.delete(id).subscribe({
        next: data => { this.cargarEduacion() },
        error: err => { alert("No se puede eliminar la educacion") }
      });
    }
  }
}
