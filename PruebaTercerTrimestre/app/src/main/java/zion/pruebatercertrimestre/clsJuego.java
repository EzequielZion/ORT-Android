package zion.pruebatercertrimestre;

import android.util.Log;
import android.view.MotionEvent;

import org.cocos2d.actions.instant.CallFunc;
import org.cocos2d.actions.instant.CallFuncN;
import org.cocos2d.actions.interval.IntervalAction;
import org.cocos2d.actions.interval.MoveBy;
import org.cocos2d.actions.interval.MoveTo;
import org.cocos2d.actions.interval.RotateBy;
import org.cocos2d.actions.interval.ScaleBy;
import org.cocos2d.actions.interval.ScaleTo;
import org.cocos2d.actions.interval.Sequence;
import org.cocos2d.layers.Layer;
import org.cocos2d.nodes.CocosNode;
import org.cocos2d.nodes.Director;
import org.cocos2d.nodes.Scene;
import org.cocos2d.nodes.Sprite;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.types.CCPoint;
import org.cocos2d.types.CCSize;

import java.security.PublicKey;
import java.security.interfaces.DSAKey;
import java.util.Random;

public class clsJuego
{
   CCGLSurfaceView _VistaDelJuego;
   CCSize PantallaDelDevice;
   Sprite Androidcito;
   Sprite Apple;
   Sprite Fondo;
   Float AlturaAndroidcito;
   Float AnchuraAndroidcito;
   Float AlturaApple;
   Float AnchuraApple;
   boolean SeMovioAndroidcito;
   boolean SeTerminoLaVuelta;
   
   public clsJuego(CCGLSurfaceView VistaDelJuego)
   {
	  _VistaDelJuego = VistaDelJuego;
   }
   
   public void ComenzarJuego()
   {
	  Director.sharedDirector().attachInView(_VistaDelJuego);
	  PantallaDelDevice = Director.sharedDirector().displaySize();
	  Director.sharedDirector().runWithScene(EscenaDelJuego());
   }
   
   private Scene EscenaDelJuego()
   {
	  Scene EscenaADevolver = Scene.node();
	  
	  CapaDelFondo MiCapaDelFondo = new CapaDelFondo();
	  
	  CapaDelFrente MiCapaDelFrente = new CapaDelFrente();
	  
	  EscenaADevolver.addChild(MiCapaDelFondo, -10);
	  EscenaADevolver.addChild(MiCapaDelFrente, 10);
	  
	  return EscenaADevolver;
   }
   
   class CapaDelFondo extends Layer
   {
	  public CapaDelFondo()
	  {
		 PonerImagenFondo();
	  }
	  
	  private void PonerImagenFondo()
	  {
		 Fondo = Sprite.sprite("samsungs8.png");
		 Float FactorAncho, FactorAlto;
		 FactorAncho = PantallaDelDevice.width / Fondo.getWidth();
		 FactorAlto = PantallaDelDevice.height / Fondo.getHeight();
		 
		 Fondo.setPosition(PantallaDelDevice.width / 2, PantallaDelDevice.height / 2);
		 Fondo.runAction(ScaleBy.action(0.01f, FactorAncho, FactorAlto));
		 super.addChild(Fondo);
	  }
   }
   
   class CapaDelFrente extends Layer
   {
	  public CapaDelFrente()
	  {
		 PonerSprites();
		 this.setIsTouchEnabled(true);
	  }
	  
	  private void PonerSprites()
	  {
		 Androidcito = Sprite.sprite("android.png");
		 Apple = Sprite.sprite("apple.png");
		 
		 Random GeneradorDePosiciones = new Random();
		 
		 CCPoint PosicionInicial1 = new CCPoint();
		 CCPoint PosicionInicial2 = new CCPoint();
		 Float AlturaSprite1, AnchuraSprite1, AlturaSprite2, AnchuraSprite2;
		 boolean FueraDeRango;
		 
		 AnchuraSprite1 = Androidcito.getWidth();
		 AlturaSprite1 = Androidcito.getHeight();
		 
		 AnchuraSprite2 = Apple.getWidth();
		 AlturaSprite2 = Apple.getHeight();
		 
		 PosicionInicial1.x = GeneradorDePosiciones.nextInt((int) (PantallaDelDevice.width - AnchuraSprite1));
		 PosicionInicial1.x += AnchuraSprite1 / 2;
		 do
		 {
			FueraDeRango = false;
			PosicionInicial1.y = 0;
			PosicionInicial1.y = GeneradorDePosiciones.nextInt((int) (PantallaDelDevice.height - AlturaSprite1));
			PosicionInicial1.y += AlturaSprite1 / 2;
			if (PosicionInicial1.y <= PantallaDelDevice.height / 2)
			{
			   FueraDeRango = true;
			}
		 } while (FueraDeRango == true);
		 
		 PosicionInicial2.x = GeneradorDePosiciones.nextInt((int) (PantallaDelDevice.width - AnchuraSprite2));
		 PosicionInicial2.x += AnchuraSprite2 / 2;
		 PosicionInicial2.y = GeneradorDePosiciones.nextInt((int) (PantallaDelDevice.height / 2 - AlturaSprite2));
		 PosicionInicial2.y += AlturaSprite2 / 2;
		 
		 Androidcito.setPosition(PosicionInicial1.x, PosicionInicial1.y);
		 Log.d("Posición Android", "X: " + Androidcito.getPositionX() + " - Y: " + Androidcito.getPositionY());
		 
		 Apple.setPosition(PosicionInicial2.x, PosicionInicial2.y);
		 Log.d("Posición Apple", "X: " + Apple.getPositionX() + " - Y: " + Apple.getPositionY());
		 
		 super.addChild(Androidcito);
		 super.addChild(Apple);
	  }
	  
	  @Override
	  public boolean ccTouchesBegan(MotionEvent event)
	  {
		 Log.d("Toque comienza", "X: " + event.getX() + " - Y: " + event.getY());
		 
		 boolean Bool = Math.random() < 0.5;
		 Float PosicionFinalX, PosicionFinalY;
		 AlturaAndroidcito = Androidcito.getHeight();
		 AnchuraAndroidcito = Androidcito.getWidth();
		 AlturaApple = Apple.getHeight();
		 AnchuraApple = Apple.getWidth();
		 
		 RotateBy RotarBro = RotateBy.action(3f, 360);
		 
		 if (Bool)
		 {
			//Se va a desplazar el Android
			PosicionFinalX = PantallaDelDevice.width - AnchuraAndroidcito / 2;
			PosicionFinalY = PantallaDelDevice.height - AlturaAndroidcito / 2;
			Androidcito.runAction(MoveTo.action(3, PosicionFinalX, PosicionFinalY));
			SeMovioAndroidcito = true;
			Log.d("¿Cuál se desplaza?", "El Android, Leo!!");
			
			//Y va a rotar el Apple
			Apple.runAction(RotarBro);
			
		 }
		 else
		 {
			//Se va a desplazar el Apple
			PosicionFinalX = PantallaDelDevice.width - AnchuraApple / 2;
			PosicionFinalY = PantallaDelDevice.height - AlturaApple / 2;
			Apple.runAction(MoveTo.action(3, PosicionFinalX, PosicionFinalY));
			SeMovioAndroidcito = false;
			Log.d("¿Cuál se desplaza?", "El Apple, Leo!!");
			
			//Y se va a rotar el Android
			Androidcito.runAction(RotarBro);
		 }
		 return true;
	  }
	  
	  @Override
	  public boolean ccTouchesMoved(MotionEvent event)
	  {
		 Log.d("Toque mueve", "X: " + event.getX() + " - Y: " + event.getY());
		 
		 RotateBy RotarQuinceBro = RotateBy.action(0.01f, 15);
		 if (SeMovioAndroidcito)
		 {
			Apple.runAction(RotarQuinceBro);
		 }
		 else
		 {
			Androidcito.runAction(RotarQuinceBro);
		 }
		 return true;
	  }
	  
	  @Override
	  public boolean ccTouchesEnded(MotionEvent event)
	  {
		 Log.d("Toque termina", "X: " + event.getX() + " - Y: " + event.getY());
	  
		 ScaleTo Inflar = ScaleTo.action(1f, 2, 2);
		 ScaleTo Desinflar = ScaleTo.action(1f, 1, 1);
		 CallFuncN Fin = CallFuncN.action(this, "FinBro");
		 IntervalAction Latir = Sequence.actions(Inflar, Desinflar, Inflar, Desinflar, Inflar, Desinflar);
	  
		 Androidcito.runAction(Latir);
		 Apple.runAction(Latir);
		 return true;
	  }
	  
	  
	  public void FinBro(CocosNode ObjetoLlamador)
	  {
		 ScaleTo Normal = ScaleTo.action(0.01f, 1, 1);
		 ObjetoLlamador.runAction(Normal);
		 //Terminó
	  }
	  
   }
}