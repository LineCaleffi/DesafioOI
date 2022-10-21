import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuariosService } from '../usuarios.service';

@Component({
  selector: 'app-form-usuarios',
  templateUrl: './form-usuarios.component.html',
  styleUrls: ['./form-usuarios.component.scss']
})
export class FormUsuariosComponent implements OnInit {
  meuForm : FormGroup = new FormGroup({});

  isEdicao : boolean = false;
  id : number = -1;

  constructor(private formBuilder: FormBuilder,
              private usuariosService: UsuariosService,
              private router: Router,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.meuForm = this.formBuilder.group({
      nome:[null, [Validators.required] ],
      cpf:[null, [Validators.required] ],
      dataNasc:[null, [Validators.required] ],
      endereco:[null, [Validators.required] ]
    });

    this.activatedRoute.params.subscribe((parametros : any)=>{
      console.log(parametros);
      if(parametros.id){
        console.log(`edição id${parametros.id}`);
        this.isEdicao=true;
        this.id=parametros.id;

        this.usuariosService.getOne(parametros.id).subscribe(
          (dadosUsuario)=>{
            console.log(dadosUsuario);
            this.meuForm.patchValue(dadosUsuario);
          }
        )
      } else{
        console.log(`criação`);
        this.isEdicao=false;
      }
    });
  }

  onSubmit(){
    if(this.isEdicao == false){
      this.usuariosService.save(this.meuForm.value).subscribe(
        (data)=>{
          console.log(data);
          this.router.navigate(['/usuarios']);
        }
      );
    }else{
      this.usuariosService.update(this.id, this.meuForm.value).subscribe(
        (data)=>{
          console.log(data);
          this.router.navigate(['/usuarios']);
        });
    }
  }
}
