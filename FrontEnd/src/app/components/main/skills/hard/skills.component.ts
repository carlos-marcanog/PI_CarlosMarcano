import { Component, OnInit } from '@angular/core';
import { Skills } from 'src/app/models/modeloSkills';
import { SkillsService } from 'src/app/services/skills.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {

  skill: Skills[] = [];

  constructor(private servicioSkill: SkillsService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarSkills();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }

  cargarSkills(): void{
    this.servicioSkill.lista().subscribe({
      next: data => { this.skill = data }
    })
  }

  delete(id:number){
    if(id != undefined){
      this.servicioSkill.delete(id).subscribe({
        next: data => { this.cargarSkills() },
        error: err => { alert("No se puede eliminar la Skill") }
      });
    }
  }
}
