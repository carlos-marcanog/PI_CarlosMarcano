import { Component, OnInit } from '@angular/core';
import { Soft } from 'src/app/models/modeloSoft';
import { SoftskillService } from 'src/app/services/softskill.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-soft-skills',
  templateUrl: './soft-skills.component.html',
  styleUrls: ['./soft-skills.component.css']
})
export class SoftSkillsComponent implements OnInit {

  soft: Soft[] = [];

  constructor(private servicioSoft: SoftskillService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarSofts();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }

  cargarSofts(): void{
    this.servicioSoft.lista().subscribe({
      next: data => { this.soft = data }
    })
  }

  delete(id:number){
    if(id != undefined){
      this.servicioSoft.delete(id).subscribe({
        next: data => { this.cargarSofts() },
        error: err => { alert("No se puede eliminar la SoftSkill") }
      });
    }
  }

}
