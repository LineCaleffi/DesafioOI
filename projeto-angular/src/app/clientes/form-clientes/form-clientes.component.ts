import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientesService } from '../clientes.service';

@Component({
  selector: 'app-form-clientes',
  templateUrl: './form-clientes.component.html',
  styleUrls: ['./form-clientes.component.scss']
})
export class FormClientesComponent implements OnInit {
  meuForm : FormGroup = new FormGroup({});

  isEdicao : boolean = false;
  id : number = -1;

  constructor(private formBuilder: FormBuilder,
              private clientesService: ClientesService,
              private router: Router,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.meuForm = this.formBuilder.group({
      nome:[null, [Validators.required] ],
      cnpj:[null, [Validators.required] ],
      endereco:[null, [Validators.required] ]
    });

    this.activatedRoute.params.subscribe((parametros : any)=>{
      console.log(parametros);
      if(parametros.id){
        console.log(`edição id${parametros.id}`);
        this.isEdicao=true;
        this.id=parametros.id;

        this.clientesService.getOne(parametros.id).subscribe(
          (dadosCliente)=>{
            console.log(dadosCliente);
            this.meuForm.patchValue(dadosCliente);
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
      this.clientesService.save(this.meuForm.value).subscribe(
        (data)=>{
          console.log(data);
          this.router.navigate(['/clientes']);
        }
      );
    }else{
      this.clientesService.update(this.id, this.meuForm.value).subscribe(
        (data)=>{
          console.log(data);
          this.router.navigate(['/clientes']);
        });
    }
  }
}
