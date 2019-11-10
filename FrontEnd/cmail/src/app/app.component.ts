import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent {

  constructor(private httpClient: HttpClient) { }

  API_KEY = 'YOUR_API_KEY';
  API = '';

  parceiro = {
    id: '',
    nome: '',
    sobrenome: '',
    email: '',
    endereco: {
      logradouro: '',
      numero: '',
      complemento: '',
      pontoReferencia: ''
    }
  } 
  public getAPI(){
    var href = window.location.href;
    if (href.includes("play-with-docker.com")) {
      this.API = href.replace("-80.direct.labs.play-with-docker.com", "-8080.direct.labs.play-with-docker.com");
    } else {
      this.API = "http://192.168.99.100:8080/api/parceiro";
    }
    return this.API;
  }

  public getNews() {
    this.httpClient.get(this.getAPI()+"/list").subscribe((data) => {
      console.log(data);
      this.postJSON();
    });
  }

  postJSON() {
    var json = JSON.stringify({
      id: 0,
      nome: this.parceiro.nome,
      sobrenome: this.parceiro.sobrenome,
      email: this.parceiro.email,
      endereco: {
        id: 0,
        logradouro: this.parceiro.endereco.logradouro,
        numero: this.parceiro.endereco.numero,
        complemento: this.parceiro.endereco.complemento,
        pontoReferencia: this.parceiro.endereco.pontoReferencia
      }
    });

    var params = 'json=' + json;
    console.log(params)

    let httpHeaders = new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Cache-Control', 'no-cache');

    let options = {
      headers: httpHeaders
    };

    return this.httpClient.post(this.getAPI(), json, options).subscribe(
      parceiro => {
        console.log(parceiro);
      },
      err => {
        console.log(err);
      }
    );
  }

  // handleNewEmail(event: Event) {
  //   event.preventDefault();
  //   console.log(this.parceiro)
  //   this.parceiro = { id: '', nome: '', sobrenome: '', email: '', endereco: ''  }
  // }
}
