import { Injectable } from '@angular/core';
import { Storage, ref, uploadBytes, list, getDownloadURL } from '@angular/fire/storage';

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  url: string = "";

  constructor(private storage: Storage) { }

  public uploadImg($event: any, name: string){
    const file = $event.target.files[0]
    console.log(file);
    const imgRef = ref(this.storage, `img/`+ name)
    uploadBytes(imgRef, file)
    .then(res => {this.getImg()})
    .catch(error => console.log(error))
  }

  getImg(){
    const imageRef = ref(this.storage, 'image')
    list(imageRef)
    .then(async res => {
      for(let item of res.items){
        this.url = await getDownloadURL(item);
        console.log("La URL es: " + this.url)
      }
    }).catch(error =>console.log(error))
  }
}
