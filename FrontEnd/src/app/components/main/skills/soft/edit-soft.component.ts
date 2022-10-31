import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Soft } from 'src/app/models/modeloSoft';
import { SoftskillService } from 'src/app/services/softskill.service';

@Component({
  selector: 'app-edit-soft',
  templateUrl: './edit-soft.component.html',
  styleUrls: ['./edit-soft.component.css']
})
export class EditSoftComponent implements OnInit {

  soft: Soft = null;
  constructor(private servicioSoft: SoftskillService, private actRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.actRouter.snapshot.params['id'];
    this.servicioSoft.detail(id).subscribe({
      next: data => { this.soft = data },
      error: err => { alert("Error al moificar la SoftSkill"), this.router.navigate(['']) }
    });
  }

  onUpdate(): void{
    const id = this.actRouter.snapshot.params['id'];
    this.servicioSoft.update(id, this.soft).subscribe({
      next: data => { this.router.navigate(['']) },
      error: err => { alert("Error al moificar la SoftSkill"), this.router.navigate(['']) }
    });
  }

}
