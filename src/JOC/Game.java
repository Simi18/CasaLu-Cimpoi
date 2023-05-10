package JOC;

import JOC.GameWindow.GameWindow;
import JOC.Graphics.Assets;
import JOC.Input.KeyManager;
import JOC.States.*;
import JOC.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable
{
        private GameWindow wnd;

        private boolean runState;

        private Thread gameThread;
        private BufferStrategy bs;
        private Graphics g;
        private State playState;            /*!< Referinta catre joc.*/
        private State menuState;            /*!< Referinta catre menu.*/
        private State settingsState;        /*!< Referinta catre setari.*/
        private State aboutState;           /*!< Referinta catre about.*/
        private KeyManager keyManager;      /*!< Referinta catre obiectul care gestioneaza intrarile din partea utilizatorului.*/
        private RefLinks refLink;            /*!< Referinta catre un obiect a carui sarcina este doar de a retine diverse referinte pentru a fi usor accesibile.*/

        private Tile tile; /*!< variabila membra temporara. Este folosita in aceasta etapa doar pentru a desena ceva pe ecran.*/
        public Game(String title)//, int width, int height)
        {
                wnd = new GameWindow(title);//, width, height);
                runState = false;
                keyManager = new KeyManager();
        }

        private void InitGame()
        {
                wnd.BuildGameWindow();
                wnd.GetWndFrame().addKeyListener(keyManager);
                //wnd.GetWndFrame().setFocusable(true);
                Assets.Init();
                refLink = new RefLinks(this);

                playState       = new PlayState(refLink);
                menuState       = new MenuState(refLink);
                settingsState   = new SettingsState(refLink);
                aboutState      = new AboutState(refLink);

                State.SetState(playState);
        }

        public void run()
        {
                /// Initializeaza obiectul game
                InitGame();
                long oldTime = System.nanoTime();   /*!< Retine timpul in nanosecunde aferent frame-ului anterior.*/
                long curentTime;                    /*!< Retine timpul curent de executie.*/

                /// Apelul functiilor Update() & Draw() trebuie realizat la fiecare 16.7 ms
                /// sau mai bine spus de 60 ori pe secunda.

                final int framesPerSecond   = 60; /*!< Constanta intreaga initializata cu numarul de frame-uri pe secunda.*/
                final double timeFrame      = 1000000000 / framesPerSecond; /*!< Durata unui frame in nanosecunde.*/

                /// Atat timp timp cat threadul este pornit Update() & Draw()
                while (runState == true)
                {
                        /// Se obtine timpul curent
                        curentTime = System.nanoTime();
                        /// Daca diferenta de timp dintre curentTime si oldTime mai mare decat 16.6 ms
                        if((curentTime - oldTime) > timeFrame)
                        {
                                /// Actualizeaza pozitiile elementelor
                                Update();
                                /// Deseneaza elementele grafica in fereastra.
                                Draw();
                                oldTime = curentTime;
                        }
                }

        }

        public synchronized void StartGame()
        {
                if(runState == false)
                {
                        /// Se actualizeaza flagul de stare a threadului
                        runState = true;
                        /// Se construieste threadul avand ca parametru obiectul Game. De retinut faptul ca Game class
                        /// implementeaza interfata Runnable. Threadul creat va executa functia run() suprascrisa in clasa Game.
                        gameThread = new Thread(this);
                        /// Threadul creat este lansat in executie (va executa metoda run())
                        gameThread.start();
                }
                else
                {
                        /// Thread-ul este creat si pornit deja
                        return;
                }
        }
        public synchronized void StopGame()
        {
                if(runState == true)
                {
                        /// Actualizare stare thread
                        runState = false;
                        /// Metoda join() arunca exceptii motiv pentru care trebuie incadrata intr-un block try - catch.
                        try
                        {
                                /// Metoda join() pune un thread in asteptare panca cand un altul isi termina executie.
                                /// Totusi, in situatia de fata efectul apelului este de oprire a threadului.
                                gameThread.join();
                        }
                        catch(InterruptedException ex)
                        {
                                /// In situatia in care apare o exceptie pe ecran vor fi afisate informatii utile pentru depanare.
                                ex.printStackTrace();
                        }
                }
                else
                {
                        /// Thread-ul este oprit deja.
                        return;
                }
        }

        private void Update()
        {

                keyManager.Update();
                if(State.GetState() != null)
                {
                        ///Actualizez starea curenta a jocului daca exista.
                        State.GetState().Update();
                }
        }


        private void Draw()
        {

                bs = wnd.GetCanvas().getBufferStrategy();
                if(bs == null)
                {

                        try
                        {
                                wnd.GetCanvas().createBufferStrategy(3);
                                return;
                        }
                        catch (Exception e)
                        {
                                e.printStackTrace();
                        }
                }

                g = bs.getDrawGraphics();

                g.clearRect(0, 0, wnd.GetWndWidth(), wnd.GetWndHeight());
                if(State.GetState() != null)
                {
                        ///Actualizez starea curenta a jocului daca exista.
                        State.GetState().Draw(g);
                }


                //g.drawRect(1 * Tile.TILE_WIDTH, 1 * Tile.TILE_HEIGHT, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);

                bs.show();

                /// Elibereaza resursele de memorie aferente contextului grafic curent (zonele de memorie ocupate de
                /// elementele grafice ce au fost desenate pe canvas).
                g.dispose();
        }
        public int GetWidth()
        {
                return wnd.GetWndWidth();
        }

        public int GetHeight()
        {
                return wnd.GetWndHeight();
        }

        public KeyManager GetKeyManager()
        {
                return keyManager;
        }
}

