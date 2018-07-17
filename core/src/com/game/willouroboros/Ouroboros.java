package com.game.willouroboros;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import static com.badlogic.gdx.Gdx.graphics;
import static com.badlogic.gdx.Gdx.input;


public class Ouroboros extends ApplicationAdapter implements InputProcessor {
	private SpriteBatch batch;
	private TextureAtlas eyeBlinking;
	private Animation<TextureRegion> animation;
	private TextureAtlas BrimStone;
	private Animation<TextureRegion> backTestAnimation;
	private TextureAtlas backTest;
	private Animation<TextureRegion> ouroIntroAnimation;
	private TextureAtlas ouroIntro;
	private TextureAtlas realEyeBlinking;
	private Animation<TextureRegion> realEyeBlinkingAnimation;
	private TextureAtlas fade;
	private Animation<TextureRegion> fadeAnimation;
	private TextureAtlas fadeToWhite;
	private Animation<TextureRegion> fadeToWhiteAnimation;
	private TextureAtlas DeathScreenSlide;
	private Animation<TextureRegion> DeathScreenSlideAnimation;
	private TextureAtlas ClockAtlas;
	private Animation<TextureRegion> ClockAnimation;
	private TextureAtlas BirdFallingAtlas;
	private Animation<TextureRegion> BirdFallingAnimation;
	private TextureAtlas BirdEscapeAtlas;
	private Animation<TextureRegion> BirdEscapeAnimation;
	private TextureAtlas BirdZZZDuringAtlas;
	private Animation<TextureRegion> BirdZZZDuringAnimation;
	private TextureAtlas BirdZZZRealDuringAtlas;
	private Animation<TextureRegion> BirdZZZRealDuringAnimation;
	private TextureAtlas CageFallingAtlas;
	private Animation<TextureRegion> CageFallingAnimation;

	//CHANGED from 0.2
	private double ScoreIncrements = 0.2;
	//was 5
	private int ScoreScale = 2;
	private int numOfBrim = 10;
	private int numOfWater = 1;
	private int numOfTime = 1;
	private int numOfBrimWhite = 5;
	private int numOfBrimBlack = 3;
	private float animationScale = 0.14f;
	private float animationBrimStoneScale = 0.07f;
	private double onFireLength = 20;
	private double curedLength = 4;
	private double timecuredLength = 4.0;
	private float doveOriginOffsetX = -70;
	private float doveOriginOffsetY = -50;
	private int fireHealth = 0;
	private double fireHealthTimerRate = 0.1;
	private int scoreMovementIncrement = 10;
	private int ScoreDisplacement = 0;
	private int backGroundPosY = -200;
	private int backGroundPosX = -80;
	private float animationScaleBack = 1.6f;
	private float backGroundFPS = 20f;
	private boolean showMainMenu = true;
	public final static float SCALE = 2.0f;
	public final static float INV_SCALE = 1.f/SCALE;
	public final static float VP_WIDTH = 1280 * INV_SCALE;
	public final static float VP_HEIGHT = 720 * INV_SCALE;

	private Animation<TextureRegion>[] animationBrimstone = new Animation[numOfBrim];
	private ParticleEffect[] fireTrail = new ParticleEffect[numOfBrim];
	private float[] brimeStoneXPos = new float[numOfBrim];
	private double[] fallingSpeed = new double[numOfBrim];
	private double[] fallRate = new double[numOfBrim];

	private ParticleEffect[] waterTrail = new ParticleEffect[numOfWater];
	private float[] waterXPos = new float[numOfWater];
	private double[] waterFallingSpeed = new double[numOfWater];
	private double[] waterFallRate = new double[numOfWater];

	private float[] timeXPos = new float[numOfTime];
	private double[] timeFallingSpeed = new double[numOfTime];
	private double[] timeFallRate = new double[numOfTime];

	private Texture[] BrimstoneWhite = new Texture[numOfBrimWhite];
	private ParticleEffect[] WhitefireTrail = new ParticleEffect[numOfBrimWhite];
	private float[] WhitebrimeStoneXPos = new float[numOfBrimWhite];
	private double[] WhitefallingSpeed = new double[numOfBrimWhite];
	private double[] WhitefallRate = new double[numOfBrimWhite];

	private Texture[] BrimstoneBlack = new Texture[numOfBrimBlack];
	private ParticleEffect[] BlackfireTrail = new ParticleEffect[numOfBrimBlack];
	private float[] BlackbrimeStoneXPos = new float[numOfBrimBlack];
	private double[] BlackfallingSpeed = new double[numOfBrimBlack];
	private double[] BlackfallRate = new double[numOfBrimBlack];

	private float timePassed;
	private OrthographicCamera camera;
	private ExtendViewport viewport;
	private ParticleEffect appleFire;
	private ParticleEffect flameHealth;
	private ParticleEffect waterHealth;
	private ParticleEffect waterHeal;
	private ParticleEffect timeHeal;
	private Texture fireHealthTexture;
	private Texture DeathScreenSmall;
	private Texture fireTexture;
	private Texture blueHealthTexture;
	private Texture backTextureTmp;
	private Texture PlayButtonTexture;
	private Texture CreditsPage;
	private Texture DeathScreen;
	private Texture LOGO;
	private Texture OpeningBackgroundIn;
	private Texture OpeningBackgroundOut;
	private Texture menuOptionTexture;
	private Texture OnFireTexture;
	private Texture WaterTexture;
	private Texture menuOptionOnPressedTexture;
	private Texture[] SnakeEight = new Texture[5];
	private Texture menuOptionOffTexture;
	private Texture menuOptionCreditsTexture;
	private Texture menuOptionOnTexture;
	private Texture menuOptionOnSFXTexture;
	private Texture menuOptionOffSFXTexture;
	private Texture logo;
	private Texture Black;
	private Texture BlackTint;
	private Texture BackDrop;
	private Texture pauseButtonTexture;
	private Texture SoundOffBox;
	private Texture SoundOnBox;
	private Texture HomeBox;
	private Texture menuOptionRetryTexture;
	private Texture DuringGameTint;
	private Texture LOGODURINGGAME;
	private Texture AreYouSureTexture;
	private Texture Jung;
	private Texture OpeningBackgroundInvert;
	private Texture Budha;
	private Texture Crowper;
	private Texture Plutarch;
	private TextureRegion fireHealthRegion;
	private TextureRegion blueHealthRegion;
	private Texture BirdCageBroken;
	private Texture OpeningBackground;
	private boolean waterCured = false;
	private float waterCuredTimer;
	private boolean timeCured = false;
	private float timeCuredTimer;
	private float introTime;
	private float EvilTime;
	private boolean onFire = false;
	private float onFireTimer;
	private boolean WIN = false;
	// Multiple of 20
	private boolean showCure = false;
	private boolean showtimeCure = false;
	private boolean dead = false;
	private BitmapFont font;
	private String XPositionTest;
	private String YPositionTest;
	private double Score;
	private String StringScore;
	private int intScore;
	private int scoreScreenOffsetY = 35;
	private Music introSongIntro;
	private Sound Flapping;
	private Sound Fire;
	private Sound HighScore;
	private Sound ScoreIncrease;
	private Sound OkKeyPress;
	private Sound StartSound;
	private Music TESTEVILMUSIC;
	private Sound ExitKeyPress;
	private Music Clock;
	private Sound EvilScoreIncrease;
	private Sound Win;
	private boolean SwitchSound = true;
	private boolean SwitchSFX = true;
	private boolean Pause = false;
	private boolean showCredits = false;
	private float timePassed2 = 0;
	private boolean ChangeBackColour = false;
	//Was 0.01f
	private float brimSpeedIncrement = 0.05f;
	private float fontPosX = 215f;
	private float ScoreDisplacementIncrement = 70f;
	private float FADEFPS = 5f;
	private Preferences prefs;
	private int[] scores = new int[5];
	private int temp;
	private int count = 0;
	private boolean firstTime = true;
	private float ScoreDisplacementMenu;
	private double brimIncrementTimer = 0;
	private boolean showAreYouSure = false;
	private float SFXVolume = 0.2f;
	private float MusicVolume = 1.0f;
	private boolean PlayScoreIncrease = false;
	private int tempScoreIncrease = 1;
	//was 0.001
	private double timeODDS = 0.005;
	private boolean drawHgihScore = false;
	private double sinFunction;
	private boolean reverseProject = false;
	private float EvilMusicPosition = 0.0f;
	private float keyPressOffset = 0.15f;
	private float TimePassedDuringGame = 0.0f;
	private float RandNum;
	private float x = 0.0f;
	private float y = 0.0f;
	private float speed = 60.0f;
	private boolean showPrologue;
	private float prologueTimePassed;
	private float fireStartTime = 2.9f;
	private float FallingCageScale = 0.6f;
	private float BackScale = 3f / 4f;
	private AssetManager manager;
	private boolean finishedUpdate = false;

	float touchX = 0;
	float touchY = 0;
	float DoveTmpTouchX;
	float DoveTmpTouchY;


	float w = VP_WIDTH;
	float h = VP_HEIGHT + 2000;


	@Override
	public void create () {

		logo = new Texture(Gdx.files.internal("LOGO.png"));

		manager = new AssetManager();

		prefs = Gdx.app.getPreferences("My Preferences");

		for (int i = 0; i < 5; i++) {
			scores[i] = prefs.getInteger("score" + i,scores[i]);
		}
		firstTime = prefs.getBoolean("firstTime", firstTime);
		SwitchSound = prefs.getBoolean("SwitchSound", SwitchSound);
		SwitchSFX = prefs.getBoolean("SwitchSFX", SwitchSFX);

		camera = new OrthographicCamera(0, 0);
		viewport = new ExtendViewport(VP_WIDTH, VP_HEIGHT, camera);
		Gdx.input.setInputProcessor(this);
		camera.position.x = 260;
		camera.position.y = 450;

		manager.load("LOGO.png", Texture.class);
		manager.finishLoading();
		manager.load("menuoptiononpressedtexture.png", Texture.class);
		logo = manager.get("LOGO.png", Texture.class);
		manager.load("Clock.mp3", Music.class);
		manager.load("OkKeyPress.ogg", Sound.class);
		manager.load("ExitKeyPress.ogg", Sound.class);
		manager.load("CurrentAppIntroMusicIntro.mp3", Music.class);
		manager.load("Flapping.ogg", Sound.class);
		manager.load("FIRE.ogg", Sound.class);
		manager.load("ScoreIncrease.ogg", Sound.class);
		manager.load("HIGHSCORE.ogg", Sound.class);
		manager.load("EvilScoreIncrease.ogg", Sound.class);
		manager.load("WIN.ogg", Sound.class);
		manager.load("TESTEVILMUSIC.mp3", Music.class);
		manager.load("StartSound.ogg", Sound.class);
		manager.load("Untitled-1.jpg", Texture.class);
		manager.load("FireHealth.png", Texture.class);
		manager.load("BlueHealth.png", Texture.class);
		manager.load("FireHealthBorder.png", Texture.class);
		manager.load("PlayButton.png", Texture.class);
		manager.load("MenuOptions.png", Texture.class);
		manager.load("MenuOptionsOn.png", Texture.class);
		manager.load("MenuOptionsOff.png", Texture.class);
		manager.load("MenuOptionsOnSFX.png", Texture.class);
		manager.load("MenuOptionsOffSFX.png", Texture.class);
		manager.load("MenuOptionsCredits.png", Texture.class);
		manager.load("Pause.png", Texture.class);
		manager.load("Black.png", Texture.class);
		manager.load("BlackTint.png", Texture.class);
		manager.load("HomeBox.png", Texture.class);
		manager.load("SoundOnBox.png", Texture.class);
		manager.load("SoundOffBox.png", Texture.class);
		manager.load("CreditsPage.png", Texture.class);
		manager.load("MenuOptionsRetry.png", Texture.class);
		manager.load("DuringGameTint.png", Texture.class);
		manager.load("OnFireTexture.png", Texture.class);
		manager.load("WaterTexture.png", Texture.class);
		manager.load("DeathScreen.png", Texture.class);
		manager.load("DeathScreenSmall.png", Texture.class);
		manager.load("AreYouSure.png", Texture.class);
		manager.load("LOGONEWTOBERESIZED.png", Texture.class);
		manager.load("LOGONEWTOBERESIZEDDuring.png", Texture.class);
		manager.load("BirdCageBroken.png", Texture.class);
		manager.load("Crowper.png", Texture.class);
		manager.load("Jung.png", Texture.class);
		manager.load("Budha.png", Texture.class);
		manager.load("Plutarch.png", Texture.class);
		manager.load("OpeningBackground.png", Texture.class);
		manager.load("OpeningBackgroundIn.png", Texture.class);
		manager.load("OpeningBackgroundOut.png", Texture.class);
		manager.load("OpeningBackgroundInvert.png", Texture.class);
		manager.load("BackDrop.png", Texture.class);
		for (int i = 0; i < 3; i++)
			manager.load("SnakeEight.png", Texture.class);
		for (int i = 0; i < numOfBrimWhite; i++)
			manager.load("WhiteBrimstone.png", Texture.class);
		for (int i = 0; i < numOfBrimBlack; i++)
			manager.load("BlackBrimstone.png", Texture.class);
		manager.load("Flapping.atlas", TextureAtlas.class);
		manager.load("ClockSecondHand.atlas", TextureAtlas.class);
		manager.load("BirdEscape.atlas", TextureAtlas.class);
		manager.load("FADE.atlas", TextureAtlas.class);
		manager.load("FadeToWhite.atlas", TextureAtlas.class);
		manager.load("TEST.atlas", TextureAtlas.class);
		manager.load("CageFalling.atlas", TextureAtlas.class);
		manager.load("BirdZZZDuring.atlas", TextureAtlas.class);
		manager.load("BirdZZZRealDuring.atlas", TextureAtlas.class);
		manager.load("EyeBlinking.atlas", TextureAtlas.class);
		manager.load("DeathScreenAnimation.atlas", TextureAtlas.class);
		manager.load("OuroIntro.atlas", TextureAtlas.class);
		manager.load("BirdFalling.atlas", TextureAtlas.class);
		manager.load("BrimStone.txt", TextureAtlas.class);
		manager.load("ScoreFont.fnt", BitmapFont.class);
	}

	@Override
	public void dispose () {
		manager.dispose();
		manager = null;
		batch.dispose();
	}

	@Override
	public void render () {
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);

		if (manager.isLoaded("LOGO.png") && manager.update() == false) {
			Gdx.gl.glClearColor(0, 0, 0, 0);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			batch.begin();
			batch.draw(logo, -90, -90);
			batch.end();
		}
		if (manager.update() && finishedUpdate == false) {
			menuOptionOnPressedTexture = manager.get("menuoptiononpressedtexture.png", Texture.class);
			Clock = manager.get("Clock.mp3", Music.class);
			OkKeyPress = manager.get("OkKeyPress.ogg", Sound.class);
			ExitKeyPress = manager.get("ExitKeyPress.ogg", Sound.class);
			introSongIntro = manager.get("CurrentAppIntroMusicIntro.mp3", Music.class);
			Flapping = manager.get("Flapping.ogg", Sound.class);
			Fire = manager.get("FIRE.ogg", Sound.class);
			ScoreIncrease = manager.get("ScoreIncrease.ogg", Sound.class);
			HighScore = manager.get("HIGHSCORE.ogg", Sound.class);
			EvilScoreIncrease = manager.get("EvilScoreIncrease.ogg", Sound.class);
			Win = manager.get("WIN.ogg", Sound.class);
			TESTEVILMUSIC = manager.get("TESTEVILMUSIC.mp3", Music.class);
			StartSound = manager.get("StartSound.ogg", Sound.class);
			backTextureTmp = manager.get("Untitled-1.jpg", Texture.class);
			fireHealthTexture = manager.get("FireHealth.png", Texture.class);
			blueHealthTexture = manager.get("BlueHealth.png", Texture.class);
			fireTexture = manager.get("FireHealthBorder.png", Texture.class);
			PlayButtonTexture = manager.get("PlayButton.png", Texture.class);
			menuOptionTexture = manager.get("MenuOptions.png", Texture.class);
			menuOptionOnTexture = manager.get("MenuOptionsOn.png", Texture.class);
			menuOptionOffTexture = manager.get("MenuOptionsOff.png", Texture.class);
			menuOptionOnSFXTexture = manager.get("MenuOptionsOnSFX.png", Texture.class);
			menuOptionOffSFXTexture = manager.get("MenuOptionsOffSFX.png", Texture.class);
			menuOptionCreditsTexture = manager.get("MenuOptionsCredits.png", Texture.class);
			pauseButtonTexture = manager.get("Pause.png", Texture.class);
			Black = manager.get("Black.png", Texture.class);
			BlackTint = manager.get("BlackTint.png", Texture.class);
			HomeBox = manager.get("HomeBox.png", Texture.class);
			SoundOnBox = manager.get("SoundOnBox.png", Texture.class);
			SoundOffBox = manager.get("SoundOffBox.png", Texture.class);
			CreditsPage = manager.get("CreditsPage.png", Texture.class);
			menuOptionRetryTexture = manager.get("MenuOptionsRetry.png", Texture.class);
			DuringGameTint = manager.get("DuringGameTint.png", Texture.class);
			OnFireTexture = manager.get("OnFireTexture.png", Texture.class);
			WaterTexture = manager.get("WaterTexture.png", Texture.class);
			DeathScreen = manager.get("DeathScreen.png", Texture.class);
			DeathScreenSmall = manager.get("DeathScreenSmall.png", Texture.class);
			AreYouSureTexture = manager.get("AreYouSure.png", Texture.class);
			LOGO = manager.get("LOGONEWTOBERESIZED.png", Texture.class);
			LOGODURINGGAME = manager.get("LOGONEWTOBERESIZEDDuring.png", Texture.class);
			BirdCageBroken = manager.get("BirdCageBroken.png", Texture.class);
			Crowper = manager.get("Crowper.png", Texture.class);
			Jung = manager.get("Jung.png", Texture.class);
			Budha = manager.get("Budha.png", Texture.class);
			Plutarch = manager.get("Plutarch.png", Texture.class);
			OpeningBackground = manager.get("OpeningBackground.png", Texture.class);
			OpeningBackgroundIn = manager.get("OpeningBackgroundIn.png", Texture.class);
			OpeningBackgroundOut = manager.get("OpeningBackgroundOut.png", Texture.class);
			OpeningBackgroundInvert = manager.get("OpeningBackgroundInvert.png", Texture.class);
			BackDrop = manager.get("BackDrop.png", Texture.class);
			for (int i = 0; i < 3; i++)
				SnakeEight[i] = manager.get("SnakeEight.png", Texture.class);
			for (int i = 0; i < numOfBrimWhite; i++)
				BrimstoneWhite[i] = manager.get("WhiteBrimstone.png", Texture.class);
			for (int i = 0; i < numOfBrimBlack; i++)
				BrimstoneBlack[i] = manager.get("BlackBrimstone.png", Texture.class);
			eyeBlinking = manager.get("Flapping.atlas", TextureAtlas.class);
			ClockAtlas = manager.get("ClockSecondHand.atlas", TextureAtlas.class);
			BirdEscapeAtlas = manager.get("BirdEscape.atlas", TextureAtlas.class);
			fade = manager.get("FADE.atlas", TextureAtlas.class);
			fadeToWhite = manager.get("FadeToWhite.atlas", TextureAtlas.class);
			backTest = manager.get("TEST.atlas", TextureAtlas.class);
			CageFallingAtlas = manager.get("CageFalling.atlas", TextureAtlas.class);
			BirdZZZDuringAtlas = manager.get("BirdZZZDuring.atlas", TextureAtlas.class);
			BirdZZZRealDuringAtlas = manager.get("BirdZZZRealDuring.atlas", TextureAtlas.class);
			realEyeBlinking = manager.get("EyeBlinking.atlas", TextureAtlas.class);
			DeathScreenSlide = manager.get("DeathScreenAnimation.atlas", TextureAtlas.class);
			ouroIntro = manager.get("OuroIntro.atlas", TextureAtlas.class);
			BirdFallingAtlas = manager.get("BirdFalling.atlas", TextureAtlas.class);
			BrimStone = manager.get("BrimStone.txt", TextureAtlas.class);
			font = manager.get("ScoreFont.fnt", BitmapFont.class);

			introSongIntro.setVolume(MusicVolume);
			Clock.setVolume(SFXVolume);
			TESTEVILMUSIC.setVolume(SFXVolume);
			font.getData().setScale(ScoreScale);
			for (int i = 0; i < numOfBrimWhite; i++) {
				WhitefireTrail[i] = new ParticleEffect();
				WhitefireTrail[i].load(Gdx.files.internal("WhiteBrimstone.txt"), Gdx.files.internal(""));
				WhitefireTrail[i].start();

				WhitebrimeStoneXPos[i] = (int) Math.round(Math.random() * 560 - 60);
				WhitefallingSpeed[i] = 0;
				WhitefallRate[i] = Math.round(Math.random() * 10 + 10);
			}
			for (int i = 0; i < numOfBrimBlack; i++) {
				BlackfireTrail[i] = new ParticleEffect();
				BlackfireTrail[i].load(Gdx.files.internal("BlackBrimstone.txt"), Gdx.files.internal(""));
				BlackfireTrail[i].start();

				BlackbrimeStoneXPos[i] = (int) Math.round(Math.random() * 560 - 60);
				BlackfallingSpeed[i] = 0;
				BlackfallRate[i] = Math.round(Math.random() * 10 + 10);
			}
			appleFire = new ParticleEffect();
			appleFire.load(Gdx.files.internal("BlueFire.txt"), Gdx.files.internal(""));
			appleFire.start();
			timeHeal = new ParticleEffect();
			timeHeal.load(Gdx.files.internal("ClockHit.txt"), Gdx.files.internal(""));
			timeHeal.start();
			waterHeal = new ParticleEffect();
			waterHeal.load(Gdx.files.internal("WaterCuring.txt"), Gdx.files.internal(""));
			waterHeal.start();
			flameHealth = new ParticleEffect();
			flameHealth.load(Gdx.files.internal("FireHealthPE.txt"), Gdx.files.internal(""));
			flameHealth.start();
			waterHealth = new ParticleEffect();
			waterHealth.load(Gdx.files.internal("WaterHealthPE.txt"), Gdx.files.internal(""));
			waterHealth.start();
			animation = new Animation<TextureRegion>(1 / 40f, eyeBlinking.getRegions());
			ClockAnimation = new Animation<TextureRegion>(1 / 1.0f, ClockAtlas.getRegions());
			BirdEscapeAnimation = new Animation<TextureRegion>(1 / 15f, BirdEscapeAtlas.getRegions());
			fadeAnimation = new Animation<TextureRegion>(1 / FADEFPS, fade.getRegions());
			fadeToWhiteAnimation = new Animation<TextureRegion>(1 / FADEFPS, fadeToWhite.getRegions());
			backTestAnimation = new Animation<TextureRegion>(1 / backGroundFPS, backTest.getRegions());
			CageFallingAnimation = new Animation<TextureRegion>(1 / 30f, CageFallingAtlas.getRegions());
			BirdZZZDuringAnimation = new Animation<TextureRegion>(1 / 7f, BirdZZZDuringAtlas.getRegions());
			BirdZZZRealDuringAnimation = new Animation<TextureRegion>(1 / 7f, BirdZZZRealDuringAtlas.getRegions());
			realEyeBlinkingAnimation = new Animation<TextureRegion>(1 / 30f, realEyeBlinking.getRegions());
			DeathScreenSlideAnimation = new Animation<TextureRegion>(1 / 15f, DeathScreenSlide.getRegions());
			ouroIntroAnimation = new Animation<TextureRegion>(1 / 20f, ouroIntro.getRegions());
			BirdFallingAnimation = new Animation<TextureRegion>(1 / 7f, BirdFallingAtlas.getRegions());

			for (int i = 0; i < numOfBrim; i++) {
				fireTrail[i] = new ParticleEffect();
				fireTrail[i].load(Gdx.files.internal("Brimestone.party"), Gdx.files.internal(""));
				fireTrail[i].start();

				brimeStoneXPos[i] = (int) Math.round(Math.random() * 560 - 60);
				fallingSpeed[i] = 0;
				fallRate[i] = (Math.random() * 8 + 2);

				animationBrimstone[i] = new Animation<TextureRegion>(1 / 30f, BrimStone.getRegions());
			}
			for (int i = 0; i < numOfWater; i++) {
				waterTrail[i] = new ParticleEffect();
				waterTrail[i].load(Gdx.files.internal("Water.txt"), Gdx.files.internal(""));
				waterTrail[i].start();

				waterXPos[i] = (int) Math.round(Math.random() * 560 - 60);
				waterFallingSpeed[i] = 0;
				waterFallRate[i] = (Math.random() * 16 + 8);
			}
			for (int i = 0; i < numOfTime; i++) {
				timeXPos[i] = (int) Math.round(Math.random() * 560 - 60);
				timeFallingSpeed[i] = 0;
				timeFallRate[i] = (Math.random() * 16 + 8);
			}
			finishedUpdate = true;
		}
		if (finishedUpdate) {
			RandNum = (float) Math.random();
			sinFunction = Math.sin(graphics.getDeltaTime()) * 2000;
			//BUBBLE SORT
			for (int i = 0; i < 5; i++) {
				for (int v = 1; v < (5 - i); v++) {
					if (scores[v - 1] < scores[v]) {
						temp = scores[v - 1];
						scores[v - 1] = scores[v];
						scores[v] = temp;
					}

				}
			}
			Gdx.gl.glClearColor(0, 0, 0, 0);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			if (Pause == false)
				timePassed += graphics.getDeltaTime();
			if (Pause == false && reverseProject == false) {
				for (int i = 0; i < numOfBrim; i++)
					fallingSpeed[i] -= Gdx.graphics.getDeltaTime() * brimIncrementTimer * brimSpeedIncrement * fallRate[i];
				for (int i = 0; i < numOfWater; i++)
					waterFallingSpeed[i] -= Gdx.graphics.getDeltaTime() * brimSpeedIncrement * waterFallRate[i] * 550;
				for (int i = 0; i < numOfBrimWhite; i++)
					WhitefallingSpeed[i] -= WhitefallRate[i];
				for (int i = 0; i < numOfBrimBlack; i++)
					BlackfallingSpeed[i] -= BlackfallRate[i];
				for (int i = 0; i < numOfTime; i++)
					timeFallingSpeed[i] -= Gdx.graphics.getDeltaTime() * brimSpeedIncrement * timeFallRate[i] * 450;
			} else if (Pause == false && reverseProject == true) {
				for (int i = 0; i < numOfBrim; i++)
					fallingSpeed[i] += fallRate[i] * 5;
				for (int i = 0; i < numOfWater; i++)
					waterFallingSpeed[i] -= waterFallRate[i] * 5;
				for (int i = 0; i < numOfBrimWhite; i++)
					WhitefallingSpeed[i] -= WhitefallRate[i] * 5;
				for (int i = 0; i < numOfBrimBlack; i++)
					BlackfallingSpeed[i] -= BlackfallRate[i] * 5;
				for (int i = 0; i < numOfTime; i++)
					timeFallingSpeed[i] -= timeFallRate[i] * 5;
			}

			//This was changed to accept the sowprologue variable
			if (dead == true || Pause == true || showMainMenu == true || timeCured == false && showtimeCure == false && showPrologue == false) {
				touchX = tp.x;
				touchY = tp.y;
			}

			if (scores[0] < intScore && scores[0] != 0 && Score < scores[0] + 1.05) {
				HighScore.play(SFXVolume);
				drawHgihScore = true;
			}

			//if (introTime < 5) {
			//introTime += Gdx.graphics.getDeltaTime();
			//batch.begin();
			//batch.draw(YingYangPulseAnimation.getKeyFrame(introTime + 3, true), backGroundPosX, backGroundPosY, 0, 0, 450, 800, animationScaleBack, animationScaleBack, 0);
			//batch.end();
			//}

			//else if (introTime < 9 && introTime > 5) {
			//introTime += Gdx.graphics.getDeltaTime();
			//batch.begin();
			//batch.draw(ouroIntroAnimation.getKeyFrame(introTime + 3, true), backGroundPosX, backGroundPosY, 0, 0, 450, 800, animationScaleBack, animationScaleBack, 0);
			//batch.end();
			//}
			//else if (introTime > 9 && introTime < 11) {
			//introTime += Gdx.graphics.getDeltaTime();
			//batch.begin();
			//batch.draw(ouroPulseAnimation.getKeyFrame(introTime + 1, true), backGroundPosX, backGroundPosY, 0, 0, 450, 800, animationScaleBack, animationScaleBack, 0);
			//batch.end();
			//}

			if (showPrologue) {
				manager.load("Budha.png", Texture.class);
				manager.load("Crowper.png", Texture.class);
				manager.load("Jung.png", Texture.class);
				manager.load("Plutarch.png", Texture.class);
				manager.load("CageFalling.atlas", TextureAtlas.class);
				prologue();
				if (firstTime && prologueTimePassed > 31.9) {
					manager.unload("Budha.png");
					manager.unload("Crowper.png");
					manager.unload("Jung.png");
					manager.unload("Plutarch.png");
					manager.unload("CageFalling.atlas");
					showMainMenu = false;
				}
			} else if (showMainMenu == true) {
				manager.load("PlayButton.png", Texture.class);
				manager.load("MenuOptions.png", Texture.class);
				manager.load("MenuOptionsCredits.png", Texture.class);
				manager.load("MenuOptionsOff.png", Texture.class);
				manager.load("MenuOptionsOffSFX.png", Texture.class);
				manager.load("MenuOptionsOn.png", Texture.class);
				manager.load("MenuOptionsOnSFX.png", Texture.class);
				manager.load("OpeningBackgroundIn.png", Texture.class);
				manager.load("OpeningBackgroundOut.png", Texture.class);
				manager.load("CreditsPage.png", Texture.class);
				manager.load("WhiteBrimstone.png", Texture.class);
				manager.load("CurrentAppIntroMusicIntro.mp3", Music.class);
				manager.load("menuoptiononpressedtexture.png", Texture.class);
				mainMenu();
				if (Gdx.input.isTouched() && touchX > 220 && touchX < 300 && touchY > 400 - scoreScreenOffsetY && touchY < 530 - scoreScreenOffsetY && showCredits == false) {
					if (SwitchSFX)
						OkKeyPress.play(SFXVolume - keyPressOffset);
					if (SwitchSFX)
						StartSound.play(SFXVolume - 0.08f);
					if (firstTime) {
						showPrologue = true;
						introSongIntro.stop();
					} else {
						showMainMenu = false;
						manager.unload("PlayButton.png");
						manager.unload("MenuOptions.png");
						manager.unload("MenuOptionsCredits.png");
						manager.unload("MenuOptionsOff.png");
						manager.unload("MenuOptionsOffSFX.png");
						manager.unload("MenuOptionsOn.png");
						manager.unload("MenuOptionsOnSFX.png");
						manager.unload("OpeningBackgroundIn.png");
						manager.unload("OpeningBackgroundOut.png");
						manager.unload("CreditsPage.png");
						manager.unload("WhiteBrimstone.png");
						manager.unload("CurrentAppIntroMusicIntro.mp3");
						manager.unload("menuoptiononpressedtexture.png");
					}
				}
			} else if (dead == false && showMainMenu == false && showPrologue == false) {
				if (Pause == true) {
					pauseInGame();
					if (Gdx.input.isTouched() && touchX > 220 && touchX < 300 && touchY > 400 - scoreScreenOffsetY && touchY < 530 - scoreScreenOffsetY && showAreYouSure == false) {
						if (SwitchSFX)
							OkKeyPress.play(SFXVolume - keyPressOffset);
						Pause = false;
						TESTEVILMUSIC.setPosition(EvilMusicPosition);
					}
				} else if (Gdx.input.justTouched() == true && touchX < 550 && touchX > 440 && touchY < 1050 - scoreScreenOffsetY && touchY > 850 - scoreScreenOffsetY) {
					if (SwitchSFX)
						ExitKeyPress.play(SFXVolume - keyPressOffset);
					Pause = true;
				} else {
					introSongIntro.stop();

					//Getting a sound to play when the score increases by one each time
					if (intScore != 8 && intScore != 88 && intScore != 888 && WIN == false && TimePassedDuringGame > fireStartTime)
						Score += Gdx.graphics.getDeltaTime() * ScoreIncrements;
					if (intScore == tempScoreIncrease && Score < tempScoreIncrease + 0.05) {
						PlayScoreIncrease = true;
						tempScoreIncrease++;
					} else {
						PlayScoreIncrease = false;
					}
					if (PlayScoreIncrease && SwitchSFX == true) {
						if (intScore != 8 && intScore != 88 && intScore != 888) {
							ScoreIncrease.play(SFXVolume);
						} else
							EvilScoreIncrease.play(SFXVolume);
					}
					PlayScoreIncrease = false;
					intScore = (int) Score;
					XPositionTest = Float.toString(Math.round(touchX));
					YPositionTest = Float.toString(Math.round(touchY));
					StringScore = Integer.toString(intScore);

					batch.begin();
					if (intScore > 999) {
						if (SwitchSFX)
							Win.play(SFXVolume);
						WIN = true;
						font.getData().setScale(2);
						font.draw(batch, String.format("YOU WIN"), 60, 700 - scoreScreenOffsetY + (int) sinFunction);
						if (input.justTouched()) {
							if (Score > scores[0]) {
								scores[4] = scores[3];
								scores[3] = scores[2];
								scores[2] = scores[1];
								scores[1] = scores[0];
								scores[0] = (int) Score;
							} else if (Score > scores[1]) {
								scores[4] = scores[3];
								scores[3] = scores[2];
								scores[2] = scores[1];
								scores[1] = (int) Score;
							} else if (Score > scores[2]) {
								scores[4] = scores[3];
								scores[3] = scores[2];
								scores[2] = (int) Score;
							} else if (Score > scores[3]) {
								scores[4] = scores[3];
								scores[3] = (int) Score;
							} else if (Score > scores[4]) {
								scores[4] = (int) Score;
							}
							WIN = false;
							if (SwitchSFX)
								OkKeyPress.play(SFXVolume - keyPressOffset);
							reverseProject = false;
							showAreYouSure = false;
							showMainMenu = true;
							EvilMusicPosition = 0.0f;
							timeCured = false;
							Pause = false;
							Score = 0;
							intScore = 0;
							scoreMovementIncrement = 10;
							ScoreDisplacement = 0;
							onFire = false;
							timePassed2 = 0;
							ChangeBackColour = false;
							fireHealth = 0;
							count = 0;
							prefs.putBoolean("firstTime", false);
							prefs.flush();
							firstTime = false;
							showPrologue = false;
							timePassed2 = 0;
							brimIncrementTimer = 0;
							tempScoreIncrease = 0;
							MusicVolume = 1.0f;
							TimePassedDuringGame = 0.0f;
							for (int i = 0; i < numOfBrim; i++) {
								fallingSpeed[i] = h;
								brimeStoneXPos[i] = (int) Math.round(Math.random() * 700 - 60);
								fallRate[i] = (Math.random() * 8 + 2);
							}
							for (int i = 0; i < numOfWater; i++) {
								waterFallingSpeed[i] = h;
								waterXPos[i] = (int) Math.round(Math.random() * 700 - 60);
								waterFallRate[i] = (Math.random() * 16 + 8);
							}
							for (int i = 0; i < numOfTime; i++) {
								timeFallingSpeed[i] = h;
								timeXPos[i] = (int) Math.round(Math.random() * 700 - 60);
								timeFallRate[i] = (Math.random() * 16 + 8);
							}
						}

					}
					if (intScore != 8 && intScore != 88 && intScore != 888 && WIN == false) {
						TimePassedDuringGame += Gdx.graphics.getDeltaTime();
						EvilTime = 0;
						if (TimePassedDuringGame > fireStartTime)
							batch.draw(backTestAnimation.getKeyFrame(timePassed, true), backGroundPosX, backGroundPosY, 0, 0, 450, 800, animationScaleBack, animationScaleBack, 0);
						else
							batch.draw(backTestAnimation.getKeyFrame(0, true), backGroundPosX, backGroundPosY, 0, 0, 450, 800, animationScaleBack, animationScaleBack, 0);
						//drawing the backdrop
						batch.draw(BackDrop, backGroundPosX, backGroundPosY + 80, 900 * BackScale, 1600 * BackScale);
						font.getData().setScale(1);

						//These few lines were for testing the exact position of the bird, FOR THE FINAL VERSION REMOVE THESE LINES, OR MAKE THEM COMENTS
						//font.draw(batch, "xtouch Pos: " + touchX, x - 300, y + 100);
						//font.draw(batch, "Y Position: " + y, x - 300, y);
						//font.draw(batch, "X Position: " + x, x - 300, y + 200);
						//font.draw(batch, "ytouch Pos: " + touchY, x - 300, y - 100);

						font.getData().setScale(2);
						if (drawHgihScore && intScore > scores[0] && Score < scores[0] + 2) {
							font.draw(batch, String.format("HIGHSCORE"), -20, 640 - scoreScreenOffsetY + (int) sinFunction);
						}
						//Moving the score when the score increases a digit
						if (intScore == scoreMovementIncrement) {
							ScoreDisplacement += ScoreDisplacementIncrement;
							scoreMovementIncrement *= 10;
						}
						//Drawing the score
						font.getData().setScale(4);
						font.draw(batch, String.format("%s", StringScore), fontPosX - ScoreDisplacement, 850 - scoreScreenOffsetY);
						batch.draw(DuringGameTint, -70, 600);
						float MoveToX = touchX;
						float MoveToY = touchY;

						float diffX = MoveToX - x;
						float diffY = MoveToY - y;

						float angle = (float) Math.atan2(diffY, diffX);

						//this if statement was to fix an error that made the bird gitter as the user moved it around
						// this error occured because the tracking statements still increased the position of the bird when the tracking varibale was equal to the positioned touched

						if (TimePassedDuringGame > fireStartTime) {
							if (touchY == y + (touchY - y) || touchY == y - (y - touchY) || touchX == x + (touchX - x) || touchX == x - (x - touchX))
								batch.draw(animation.getKeyFrame(timePassed, true), touchX, touchY, doveOriginOffsetX, doveOriginOffsetY, 835, 559, animationScale, animationScale, 0);
							else {
								batch.draw(animation.getKeyFrame(timePassed, true), x, y, doveOriginOffsetX, doveOriginOffsetY, 835, 559, animationScale, animationScale, 0);
							}
						}
						//This else statement is here because I want the bird to spawn in the middle of the screen when the game starts
						else if (TimePassedDuringGame > 1.35 && TimePassedDuringGame < 2.0) {
							touchX = 0;
							touchY = 400;
						}
						x += speed * Math.cos(angle);
						y += speed * Math.sin(angle);
						if (timeCured == false && showtimeCure == false)
							batch.draw(pauseButtonTexture, 490, 940 - scoreScreenOffsetY);
						DoveTmpTouchX = x;
						DoveTmpTouchY = y;

						//if the fire reaches the bottom of the screen

						if (TimePassedDuringGame > fireStartTime) {
							for (int i = 0; i < numOfBrim; i++) {
								brimIncrementTimer++;
								if (fallingSpeed[i] + h < -500) {
									fallingSpeed[i] = h - 1000;
									brimeStoneXPos[i] = (int) Math.round(Math.random() * 700 - 60);
									fallRate[i] = (Math.random() * 8 + 2);
								}
								//Drawing the brimstone
								else {
									for (int r = 0; r < numOfBrim; r++) {
										fireTrail[r].setPosition((int) brimeStoneXPos[r], (float) fallingSpeed[r] + h);
										fireTrail[r].draw(batch);
										batch.draw(animationBrimstone[r].getKeyFrame(timePassed, true), brimeStoneXPos[r] - 17, (float) fallingSpeed[r] + h, 0, 0, 520, 430, animationBrimStoneScale, animationBrimStoneScale, 0);
									}
								}
							}
						}
						//if the water reaches the bottom of the screen
						for (int i = 0; i < numOfWater; i++) {
							if (waterFallingSpeed[i] + h < -500) {
								waterFallingSpeed[i] = h;
								waterXPos[i] = (int) Math.round(Math.random() * 700 - 60);
								waterFallRate[i] = (Math.random() * 16 + 8);
							}
							//Drawing the water
							else {
								for (int r = 0; r < numOfWater; r++) {
									waterTrail[r].setPosition((int) waterXPos[r], (float) waterFallingSpeed[r] + h);
									waterTrail[r].draw(batch);
								}
							}
						}
						//Drawing the water hitting the user
						if (waterCured == true && showCure == true) {
							waterCuredTimer += graphics.getDeltaTime();
							waterHeal.setPosition(x, y);
							waterHeal.draw(batch);
							if (waterCuredTimer > curedLength) {
								if (onFire == true)
									onFire = false;
								waterCured = false;
								showCure = false;
								waterCuredTimer = 0;
							}
						}
						// if the player is hit with water
						for (int i = 0; i < numOfWater; i++) {
							if (x + doveOriginOffsetX > waterXPos[i] - 100 && x + doveOriginOffsetX < waterXPos[i] && waterFallingSpeed[i] + h < y + doveOriginOffsetY + 140 && waterFallingSpeed[i] + h > y + doveOriginOffsetY) {
								if (TimePassedDuringGame > 5) {
									onFire = false;
									waterCured = true;
									showCure = true;
								}
							}
						}
						//if the time reaches the bottom of the screen
						for (int i = 0; i < numOfTime; i++) {
							if (timeFallingSpeed[i] + h < -500 && Math.random() < timeODDS) {
								timeFallingSpeed[i] = h;
								timeXPos[i] = (int) Math.round(Math.random() * 700 - 60);
								timeFallRate[i] = (Math.random() * 16 + 8);
							}
							//Drawing the time
							else {
								for (int r = 0; r < numOfTime; r++) {
									WhitefireTrail[r].setPosition((int) timeXPos[r], (float) timeFallingSpeed[r] + h);
									WhitefireTrail[r].draw(batch);
								}
							}
						}
					} else if (intScore == 8 || intScore == 88 || intScore == 888) {
						float MoveToX = touchX;
						float MoveToY = touchY;

						float diffX = MoveToX - x;
						float diffY = MoveToY - y;

						float angle = (float) Math.atan2(diffY, diffX);

						//this if statement was to fix an error that made the bird gitter as the user moved it around
						// this error occured because the tracking statements still increased the position of the bird when the tracking varibale was equal to the positioned touched

						if (TimePassedDuringGame > fireStartTime) {
							if (touchY == y + (touchY - y) || touchY == y - (y - touchY) || touchX == x + (touchX - x) || touchX == x - (x - touchX))
								batch.draw(animation.getKeyFrame(timePassed, true), touchX, touchY, doveOriginOffsetX, doveOriginOffsetY, 835, 559, animationScale, animationScale, 0);
							else {
								batch.draw(animation.getKeyFrame(timePassed, true), x, y, doveOriginOffsetX, doveOriginOffsetY, 835, 559, animationScale, animationScale, 0);
							}
						}
						x += speed * Math.cos(angle);
						y += speed * Math.sin(angle);
						TimePassedDuringGame += Gdx.graphics.getDeltaTime();
						if (Pause == false) {
							if (SwitchSFX)
								TESTEVILMUSIC.play();
							EvilMusicPosition = TESTEVILMUSIC.getPosition();
						}
						EvilTime += Gdx.graphics.getDeltaTime();
						font.getData().setScale(6);
						if (EvilTime < 2.8)
							batch.draw(ouroIntroAnimation.getKeyFrame(EvilTime, true), backGroundPosX, backGroundPosY, 0, 0, 450, 800, animationScaleBack, animationScaleBack, 0);
						for (int i = 0; i < numOfBrim; i++) {
							brimIncrementTimer++;
							if (fallingSpeed[i] + h < -500) {
								fallingSpeed[i] = h - 1000;
								brimeStoneXPos[i] = i * 60;
								fallRate[i] = (Math.random() * 8 + 2);
							}
							//Drawing the brimstone
							else {
								for (int r = 0; r < numOfBrim; r++) {
									fireTrail[r].setPosition((int) brimeStoneXPos[r], (float) fallingSpeed[r] + h);
									fireTrail[r].draw(batch);
									batch.draw(animationBrimstone[r].getKeyFrame(EvilTime, true), brimeStoneXPos[r] - 17, (float) fallingSpeed[r] + h, 0, 0, 520, 430, animationBrimStoneScale, animationBrimStoneScale, 0);
								}
							}
						}
						if (EvilTime > 2.8)
							batch.draw(realEyeBlinkingAnimation.getKeyFrame(EvilTime, true), backGroundPosX - 30, backGroundPosY - 650, 0, 0, 1551, 3530, 0.5f, 0.5f, 0);
						if (touchY == y + (touchY - y) || touchY == y - (y - touchY) || touchX == x + (touchX - x) || touchX == x - (x - touchX))
							batch.draw(animation.getKeyFrame(timePassed, true), touchX, touchY, doveOriginOffsetX, doveOriginOffsetY, 835, 559, animationScale, animationScale, 0);
						else {
							batch.draw(animation.getKeyFrame(timePassed, true), x, y, doveOriginOffsetX, doveOriginOffsetY, 835, 559, animationScale, animationScale, 0);
						}
						batch.draw(pauseButtonTexture, 490, 940 - scoreScreenOffsetY);
						font.draw(batch, String.format("%s", StringScore), fontPosX - ScoreDisplacement * 3 / 2 - 20, 860 - scoreScreenOffsetY);
						if (intScore == 8)
							batch.draw(SnakeEight[0], fontPosX - ScoreDisplacement * 3 / 2 - 45, 690 - scoreScreenOffsetY);
						if (intScore == 88) {
							batch.draw(SnakeEight[0], fontPosX - ScoreDisplacement * 3 / 2 - 45 + 192, 690 - scoreScreenOffsetY);
							batch.draw(SnakeEight[1], fontPosX - ScoreDisplacement * 3 / 2 - 45, 690 - scoreScreenOffsetY);
						}
						if (intScore == 888) {
							batch.draw(SnakeEight[0], fontPosX - ScoreDisplacement * 3 / 2 - 45 + 198, 690 - scoreScreenOffsetY);
							batch.draw(SnakeEight[1], fontPosX - ScoreDisplacement * 3 / 2 - 45, 690 - scoreScreenOffsetY);
							batch.draw(SnakeEight[2], fontPosX - ScoreDisplacement * 3 / 2 - 45 + 385, 690 - scoreScreenOffsetY);
						}
						DoveTmpTouchX = x;
						DoveTmpTouchY = y;
						if (EvilTime > 18)
							Score += 1;
					}

					//resetting the timepassed varibale to zero so that the clock animation will start from zero
					//Drawing the time hitting the user
					if (timeCured == true && showtimeCure == true) {
						timePassed = 0;
						reverseProject = true;
						timeCuredTimer += graphics.getDeltaTime();
						timeHeal.setPosition(x, y);
						timeHeal.draw(batch);
						if (timeCuredTimer > timecuredLength) {
							timeCured = false;
							showtimeCure = false;
							timeCuredTimer = 0;
							Clock.stop();
							reverseProject = false;
							x = DoveTmpTouchX;
							y = DoveTmpTouchY;
						} else {
							if (SwitchSFX)
								Clock.play();
							batch.draw(ClockAnimation.getKeyFrame(timeCuredTimer, true), -30, 350 - scoreScreenOffsetY, 0, 0, 400, 400, 1.5f, 1.5f, 0);
							brimIncrementTimer = 0;
						}
					}
					// if the player is hit with time
					for (int i = 0; i < numOfTime; i++) {
						if (x + doveOriginOffsetX > timeXPos[i] - 100 && x + doveOriginOffsetX < timeXPos[i] && timeFallingSpeed[i] + h < y + doveOriginOffsetY + 140 && timeFallingSpeed[i] + h > y + doveOriginOffsetY) {
							if (TimePassedDuringGame > 5) {
								timeCured = true;
								showtimeCure = true;
							}
						}
					}
					for (int i = 0; i < numOfBrim; i++) {
						//Player is hit with fire / brimstone
						if (x + doveOriginOffsetX > brimeStoneXPos[i] - 80 && x + doveOriginOffsetX < brimeStoneXPos[i] - 20 && fallingSpeed[i] + h < y + doveOriginOffsetY + 100 && fallingSpeed[i] + h > y + doveOriginOffsetY) {
							if (TimePassedDuringGame > 4)
								dead = true;
						}
						//Player touches the trail of fire
						if (x + doveOriginOffsetX > brimeStoneXPos[i] - 100 && x + doveOriginOffsetX < brimeStoneXPos[i] && fallingSpeed[i] + h < y + doveOriginOffsetY && fallingSpeed[i] + h > y + doveOriginOffsetY - 300 * brimIncrementTimer) {
							if (TimePassedDuringGame > 5)
								onFire = true;
						}
					}
					batch.draw(fireTexture, -30, 940 - scoreScreenOffsetY);
					if (onFire == true) {
						onFireTimer += graphics.getDeltaTime();
						appleFire.setPosition(x, y);
						appleFire.draw(batch);
						if (onFireTimer > onFireLength) {
							onFire = false;
							onFireTimer = 0;
						}
						if (fireHealth > 0) {
							batch.draw(WaterTexture, 270, 925 - scoreScreenOffsetY);
						} else if (fireHealth == 0) {
							batch.draw(OnFireTexture, 270, 925 - scoreScreenOffsetY);
						}

					}
					for (int i = 0; i < numOfBrim; i++)
						fireTrail[i].update(graphics.getDeltaTime());

					for (int i = 0; i < numOfWater; i++)
						waterTrail[i].update(graphics.getDeltaTime());

					for (int i = 0; i < numOfTime; i++)
						WhitefireTrail[i].update(graphics.getDeltaTime());

					appleFire.update(graphics.getDeltaTime());
					waterHeal.update(graphics.getDeltaTime());
					flameHealth.update(graphics.getDeltaTime());
					waterHealth.update(graphics.getDeltaTime());
					timeHeal.update(graphics.getDeltaTime());

					// if the player is on fire and their timer is still increasing
					// 340 was changed to 250
					if (onFire == true && fireHealth <= 250) {
						fireHealth += onFireTimer * fireHealthTimerRate;
						flameHealth.setPosition(fireHealth - 30, 900 + scoreScreenOffsetY);
						flameHealth.draw(batch);
						batch.draw(fireHealthRegion, -31, 439 + scoreScreenOffsetY);

						// if the player is on fire and their fireHealth is decreasing
					} else if (onFire == false && fireHealth > 0) {
						fireHealth -= onFireTimer * fireHealthTimerRate;
						waterHealth.setPosition(fireHealth - 30, 900 + scoreScreenOffsetY);
						waterHealth.draw(batch);
						batch.draw(blueHealthRegion, -31, 439 + scoreScreenOffsetY);
					}

					// Drawing the regions of the health bars
					fireHealthRegion = new TextureRegion(fireHealthTexture, 0, 0, fireHealth, 439 + scoreScreenOffsetY);
					blueHealthRegion = new TextureRegion(blueHealthTexture, 0, 0, fireHealth, 439 + scoreScreenOffsetY);
					// 340 was changed to 250
					if (fireHealth > 250) {
						if (TimePassedDuringGame > 4)
							dead = true;
					}

					if (showPrologue == false) {
						manager.load("BirdCageBroken.png", Texture.class);
						manager.load("BirdEscape.atlas", TextureAtlas.class);
						manager.load("BirdZZZDuring.atlas", TextureAtlas.class);
						manager.load("BirdZZZRealDuring.atlas", TextureAtlas.class);
						if (TimePassedDuringGame < 0.4) {
							batch.draw(BirdZZZDuringAnimation.getKeyFrame(TimePassedDuringGame, true), 150, 0, 0, 0, 400, 484, FallingCageScale, FallingCageScale, 0);
						} else if (TimePassedDuringGame > 0.4 && TimePassedDuringGame < 1.6) {
							batch.draw(BirdZZZRealDuringAnimation.getKeyFrame(TimePassedDuringGame, true), 150, 0, 0, 0, 400, 484, FallingCageScale, FallingCageScale, 0);
						} else if (TimePassedDuringGame > 1.6 && TimePassedDuringGame < fireStartTime) {
							batch.draw(BirdEscapeAnimation.getKeyFrame(TimePassedDuringGame, true), 150, 0, 0, 0, 400, 878, FallingCageScale, FallingCageScale, 0);
						} else if (TimePassedDuringGame > fireStartTime && TimePassedDuringGame < fireStartTime + 1) {
							batch.draw(BirdCageBroken, 150, 725 - 250 * TimePassedDuringGame, 400 * FallingCageScale, 878 * FallingCageScale);
						}
						else {
							manager.unload("BirdCageBroken.png");
							manager.unload("BirdEscape.atlas");
							manager.unload("BirdZZZDuring.atlas");
							manager.unload("BirdZZZRealDuring.atlas");
						}
					}
					batch.end();
				}
				//Death screen
			} else {
				manager.load("DeathScreenAnimation.atlas", TextureAtlas.class);
				manager.load("DeathScreen.png", Texture.class);
				manager.load("MenuOptionsRetry.png", Texture.class);
				manager.load("BlackBrimstone.png", Texture.class);
				manager.load("OpeningBackgroundInvert.png", Texture.class);
				manager.load("BirdFalling.atlas", TextureAtlas.class);
				manager.load("OpeningBackground.png", Texture.class);
				manager.load("DeathScreenSmall.png", Texture.class);
				manager.load("FadeToWhite.atlas", TextureAtlas.class);
				manager.load("CurrentAppIntroMusicIntro.mp3", Music.class);
				if (SwitchSound == true)
					introSongIntro.play();
				TESTEVILMUSIC.stop();
				if (count < 1) {
					if (Score > scores[0]) {
						scores[4] = scores[3];
						scores[3] = scores[2];
						scores[2] = scores[1];
						scores[1] = scores[0];
						scores[0] = (int) Score;
					} else if (Score > scores[1]) {
						scores[4] = scores[3];
						scores[3] = scores[2];
						scores[2] = scores[1];
						scores[1] = (int) Score;
					} else if (Score > scores[2]) {
						scores[4] = scores[3];
						scores[3] = scores[2];
						scores[2] = (int) Score;
					} else if (Score > scores[3]) {
						scores[4] = scores[3];
						scores[3] = (int) Score;
					} else if (Score > scores[4]) {
						scores[4] = (int) Score;
					}
				}
				count++;
				for (int x = 0; x < 5; x++) {
					prefs.putInteger("score" + x, scores[x]);
					prefs.flush();
				}
				timePassed = 0;
				if (ChangeBackColour == false) {
					Gdx.gl.glClearColor(0, 0, 0, 0);
					Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
				} else {
					Gdx.gl.glClearColor(1, 1, 1, 1);
					Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
				}
				timePassed2 += Gdx.graphics.getDeltaTime();
				batch.begin();
				batch.draw(OpeningBackground, backGroundPosX, backGroundPosY + 80, 900 * BackScale, 1600 * BackScale);
				batch.draw(BirdFallingAnimation.getKeyFrame(timePassed2, true), -50, 2000 - timePassed2 * 1100, 0, 0, 688, 512, 0.35f, 0.35f, 0);
				batch.draw(DeathScreenSmall, -20, 0 - scoreScreenOffsetY);

				if (timePassed2 > 2.1 && timePassed2 < 2.8) {
					ChangeBackColour = true;
					if (timePassed2 < 2.8)
						batch.draw(fadeToWhiteAnimation.getKeyFrame(timePassed2 + 0.5f, true), backGroundPosX, backGroundPosY, 0, 0, 450, 800, animationScaleBack, animationScaleBack, 0);
					batch.draw(DeathScreenSlideAnimation.getKeyFrame(timePassed2 - 0.2f, true), -20, 0 - scoreScreenOffsetY, 0, 0, 552, 955, 1.0f, 1.0f, 0);
				} else if (timePassed2 > 2.8) {
					batch.draw(OpeningBackgroundInvert, backGroundPosX, backGroundPosY + 80, 900 * BackScale, 1600 * BackScale);
					for (int i = 0; i < numOfBrimBlack; i++) {
						if (WhitefallingSpeed[i] + h < -500) {
							WhitefallingSpeed[i] = h - 1000;
							WhitebrimeStoneXPos[i] = (int) Math.round(Math.random() * 560 - 60);
							WhitefallRate[i] = Math.round(Math.random() * 10 + 10);
						}
						//Drawing the brimstone
						else {
							for (int r = 0; r < numOfBrimBlack; r++) {
								BlackfireTrail[r].setPosition((int) WhitebrimeStoneXPos[r], (float) WhitefallingSpeed[r] + h);
								BlackfireTrail[r].draw(batch);
								batch.draw(BrimstoneBlack[r], WhitebrimeStoneXPos[r] - 47, (float) WhitefallingSpeed[r] + h - 36);
							}
						}
					}
					for (int i = 0; i < numOfBrimBlack; i++)
						BlackfireTrail[i].update(graphics.getDeltaTime());
					batch.draw(DeathScreen, -20, 1 - scoreScreenOffsetY);
					if (Gdx.input.justTouched() == true && touchX > 120 && touchX < 400 && touchY > 50 - scoreScreenOffsetY && touchY < 180 - scoreScreenOffsetY) {
						if (SwitchSFX)
							ExitKeyPress.play(SFXVolume - keyPressOffset);
						EvilMusicPosition = 0.0f;
						showMainMenu = true;
						Pause = false;
						Score = 0;
						dead = false;
						intScore = 0;
						timeCured = false;
						scoreMovementIncrement = 10;
						ScoreDisplacement = 0;
						onFire = false;
						timePassed2 = 0;
						waterCured = false;
						ChangeBackColour = false;
						MusicVolume = 1.0f;
						fireHealth = 0;
						count = 0;
						prefs.putBoolean("firstTime", false);
						reverseProject = false;
						prefs.flush();
						firstTime = false;
						showPrologue = false;
						timePassed2 = 0;
						brimIncrementTimer = 0;
						tempScoreIncrease = 0;
						TimePassedDuringGame = 0.0f;
						for (int i = 0; i < numOfBrim; i++) {
							fallingSpeed[i] = h;
							brimeStoneXPos[i] = (int) Math.round(Math.random() * 700 - 60);
							fallRate[i] = (Math.random() * 8 + 2);
						}
						for (int i = 0; i < numOfWater; i++) {
							waterFallingSpeed[i] = h;
							waterXPos[i] = (int) Math.round(Math.random() * 700 - 60);
							waterFallRate[i] = (Math.random() * 16 + 8);
						}
						for (int i = 0; i < numOfTime; i++) {
							timeFallingSpeed[i] = h;
							timeXPos[i] = (int) Math.round(Math.random() * 700 - 60);
							timeFallRate[i] = (Math.random() * 16 + 8);
						}
					}
					batch.draw(menuOptionRetryTexture, 125, 25 - scoreScreenOffsetY);
					font.getData().setScale(4);
					font.draw(batch, String.format(StringScore), fontPosX - ScoreDisplacement, 720);
					for (int i = 0; i < 5; i++) {
						font.getData().setScale(1);
						font.draw(batch, String.format("" + scores[i]), 230, 532 - i * 80f);
					}
				}
				batch.end();
			}
		}
	}

	public void mainMenu() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		introTime += Gdx.graphics.getDeltaTime();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.draw(OpeningBackground, backGroundPosX, backGroundPosY + 80, 900 * BackScale, 1600 * BackScale);
		batch.draw(realEyeBlinkingAnimation.getKeyFrame(introTime, true), backGroundPosX - 30, backGroundPosY - 650, 0, 0, 1551, 3530, 0.5f, 0.5f, 0);

		//Drawing the falling brimstone
		if (firstTime == false)
			batch.draw(BirdFallingAnimation.getKeyFrame(introTime, true), (int) brimeStoneXPos[0] - 125, (float) fallingSpeed[0] + h - 50, 0, 0, 688, 512, 0.35f, 0.35f, 0);

		//drawing the birdcage, if the user plays for their first time it is holds the bird, if not the cage is empty

		for (int i = 0; i < numOfBrimWhite; i++) {
			if (WhitefallingSpeed[i] + h < -500) {
				WhitefallingSpeed[i] = h - 1000;
				WhitebrimeStoneXPos[i] = (int) Math.round(Math.random() * 560 - 60);
				WhitefallRate[i] = Math.round(Math.random() * 10 + 10);
			}
			//Drawing the brimstone
			else {
				for (int r = 0; r < numOfBrimWhite; r++) {
					WhitefireTrail[r].setPosition((int) WhitebrimeStoneXPos[r], (float) WhitefallingSpeed[r] + h);
					WhitefireTrail[r].draw(batch);
					batch.draw(BrimstoneWhite[r], WhitebrimeStoneXPos[r] - 47, (float) WhitefallingSpeed[r] + h - 36);
				}
			}
		}
		if (fallingSpeed[0] + h < -500) {
			fallingSpeed[0] = h - 1000;
			brimeStoneXPos[0] = (int) Math.round(Math.random() * 560 - 60);
			fallRate[0] = Math.round(Math.random() * 2 + 2);
		}
		for (int i = 0; i < numOfBrimWhite; i++)
			WhitefireTrail[i].update(graphics.getDeltaTime());
		fireTrail[0].update(graphics.getDeltaTime());
		if (firstTime)
			batch.draw(OpeningBackgroundIn, backGroundPosX, backGroundPosY + 40, 900 * BackScale, 1600 * BackScale);
		else
			batch.draw(OpeningBackgroundOut, backGroundPosX, backGroundPosY + 40, 900 * BackScale, 1600 * BackScale);

		if (firstTime)
			batch.draw(menuOptionOnPressedTexture, 115, 200 - scoreScreenOffsetY);
		else
			batch.draw(menuOptionTexture, 115, 200 - scoreScreenOffsetY);
		if (Gdx.input.justTouched() == true && touchX > -150 && touchX < 230 && touchY > 100 - scoreScreenOffsetY && touchY < 230 - scoreScreenOffsetY && SwitchSound == false && showCredits == false) {
			if (SwitchSFX)
				OkKeyPress.play(SFXVolume - keyPressOffset);
			SwitchSound = true;
			prefs.putBoolean("SwitchSound", true);
			prefs.flush();
		} else if (Gdx.input.justTouched() == true && touchX > -150 && touchX < 230 && touchY > 100 - scoreScreenOffsetY && touchY < 230 - scoreScreenOffsetY && SwitchSound == true && showCredits == false) {
			if (SwitchSFX)
				ExitKeyPress.play(SFXVolume - keyPressOffset);
			SwitchSound = false;
			prefs.putBoolean("SwitchSound", false);
			prefs.flush();
		}
		if (SwitchSound == true) {
			batch.draw(menuOptionOnTexture, -50, 75 - scoreScreenOffsetY);
			introSongIntro.play();
		} else if (SwitchSound == false) {
			batch.draw(menuOptionOffTexture, -50, 75 - scoreScreenOffsetY);
			introSongIntro.stop();
		}
		if (Gdx.input.justTouched() == true && touchX > 250 && touchX < 630 && touchY > 100 - scoreScreenOffsetY && touchY < 230 - scoreScreenOffsetY && SwitchSFX == false && showCredits == false) {
			OkKeyPress.play(SFXVolume - keyPressOffset);
			SwitchSFX = true;
			prefs.putBoolean("SwitchSFX", true);
			prefs.flush();
		} else if (Gdx.input.justTouched() == true && touchX > 250 && touchX < 630 && touchY > 100 - scoreScreenOffsetY && touchY < 230 - scoreScreenOffsetY && SwitchSFX == true && showCredits == false) {
			SwitchSFX = false;
			prefs.putBoolean("SwitchSFX", false);
			prefs.flush();
		}
		if (SwitchSFX == true) {
			batch.draw(menuOptionOnSFXTexture, 270, 75 - scoreScreenOffsetY);
		} else {
			batch.draw(menuOptionOffSFXTexture, 270, 75 - scoreScreenOffsetY);
		}
		batch.draw(menuOptionCreditsTexture, 115, -50 - scoreScreenOffsetY);
		batch.draw(PlayButtonTexture, 60, 280 - scoreScreenOffsetY);
		if (scores[0] > 9) {
			ScoreDisplacementMenu = ScoreDisplacementIncrement / 4;
		}
		if (scores[0] > 99) {
			ScoreDisplacementMenu = ScoreDisplacementIncrement / 4 * 2;
		}
		if (scores[0] > 999) {
			ScoreDisplacementMenu = ScoreDisplacementIncrement / 4 * 3;
		}
		if (scores[0] > 9999) {
			ScoreDisplacementMenu = ScoreDisplacementIncrement / 4 * 4;
		}
		if (scores[0] > 99999) {
			ScoreDisplacementMenu = ScoreDisplacementIncrement / 4 * 5;
		}
		if (scores[0] > 999999) {
			ScoreDisplacementMenu = ScoreDisplacementIncrement / 4 * 6;
		}
		if (scores[0] > 0) {
			font.getData().setScale(1);
			font.draw(batch, String.format("%s", "" + scores[0]), fontPosX - ScoreDisplacementMenu + 30, 750 - scoreScreenOffsetY);
		}
		font.getData().setScale(2.0f);
		font.draw(batch, String.format("%s", "OUROBOROS"), -20, 900 - scoreScreenOffsetY);
		if (Gdx.input.justTouched() == true && touchX > 120 && touchX < 400 && touchY > -25 - scoreScreenOffsetY && touchY < 105 - scoreScreenOffsetY && showCredits == false) {
			if (SwitchSFX)
				OkKeyPress.play(SFXVolume - keyPressOffset);
			showCredits = true;
		}
		if (showCredits == true) {
			batch.draw(CreditsPage, -85, -205);
			if (Gdx.input.justTouched() == true && touchX < 500 && touchX > 430 && touchY < 1050 - scoreScreenOffsetY && touchY > 850 - scoreScreenOffsetY) {
				if (SwitchSFX)
					ExitKeyPress.play(SFXVolume - keyPressOffset);
				showCredits = false;
			}
		}
		if (showPrologue == false) {
			if (Gdx.input.justTouched() == true && touchX > 120 && touchX < 400 && touchY > 225 - scoreScreenOffsetY && touchY < 355 - scoreScreenOffsetY && firstTime == false) {
				introSongIntro.stop();
				showPrologue = true;
			}
		}
		batch.end();

	}
	// 33 seconds approx.
	public void prologue() {
		prologueTimePassed += Gdx.graphics.getDeltaTime();

		batch.begin();
		if (SwitchSound)
			introSongIntro.play();
		if (prologueTimePassed < 8) {
			batch.draw(Crowper, backGroundPosX, backGroundPosY + 80, 900 * BackScale, 1600* BackScale);
			batch.draw(CageFallingAnimation.getKeyFrame(prologueTimePassed, true), 150, 2000 - prologueTimePassed * 400, 0, 0, 400, 834, FallingCageScale, FallingCageScale, 0);
		}
		else if (prologueTimePassed > 8 && prologueTimePassed < 16) {
			batch.draw(Budha, backGroundPosX, backGroundPosY + 80, 900* BackScale, 1600* BackScale);
			batch.draw(CageFallingAnimation.getKeyFrame(prologueTimePassed, true), 150, 2000 - prologueTimePassed * 400 + 8 * 400, 0, 0, 400, 834, FallingCageScale, FallingCageScale, 0);
		}
		else if (prologueTimePassed > 16 && prologueTimePassed < 24) {
			batch.draw(Jung, backGroundPosX, backGroundPosY + 80, 900* BackScale, 1600 * BackScale);
			batch.draw(CageFallingAnimation.getKeyFrame(prologueTimePassed, true), 150, 2000 - prologueTimePassed * 400 + 16 * 400, 0, 0, 400, 834, FallingCageScale, FallingCageScale, 0);
		}
		else if (prologueTimePassed > 24 && prologueTimePassed < 29) {
			//The variable TimePassedDuringGame will make it so that the grass stays put
			batch.draw(backTestAnimation.getKeyFrame(TimePassedDuringGame, true), backGroundPosX, backGroundPosY, 0, 0, 450, 800, animationScaleBack, animationScaleBack, 0);
			batch.draw(BackDrop, backGroundPosX, backGroundPosY + 80, 900 * BackScale, 1600 * BackScale);
			batch.draw(Plutarch, backGroundPosX, backGroundPosY + 80, 900 * BackScale, 1600 * BackScale);
			batch.draw(CageFallingAnimation.getKeyFrame(prologueTimePassed, true), 150, 2000 - prologueTimePassed * 400 + 24 * 400, 0, 0, 400, 834, FallingCageScale, FallingCageScale, 0);
		}
		else if (prologueTimePassed > 29 && prologueTimePassed < 32) {
			batch.draw(backTestAnimation.getKeyFrame(TimePassedDuringGame, true), backGroundPosX, backGroundPosY, 0, 0, 450, 800, animationScaleBack, animationScaleBack, 0);
			//drawing the backdrop
			batch.draw(BackDrop, backGroundPosX, backGroundPosY + 80, 900 * BackScale, 1600 * BackScale);
			batch.draw(BirdZZZRealDuringAnimation.getKeyFrame(prologueTimePassed, true), 150, 0, 0, 0, 400, 484, FallingCageScale, FallingCageScale, 0);
		}
		else if (prologueTimePassed > 32) {
			prologueTimePassed = 0.0f;
			introSongIntro.stop();
			showPrologue = false;
		}
		batch.end();

	}

	@Override
	public void resize (int width, int height) {
		viewport.update(width, height);
	}

	@Override
	public void pause() {
		if (manager.update()) {
			Pause = true;
			batch.begin();
			batch.draw(OpeningBackground, backGroundPosX, backGroundPosY + 80, 900 * BackScale, 1600 * BackScale);
			if (firstTime)
				batch.draw(OpeningBackgroundIn, backGroundPosX, backGroundPosY + 40, 900 * BackScale, 1600 * BackScale);
			else
				batch.draw(OpeningBackgroundOut, backGroundPosX, backGroundPosY + 40, 900 * BackScale, 1600 * BackScale);
			batch.draw(BackDrop, backGroundPosX, backGroundPosY + 80, 900 * BackScale, 1600 * BackScale);
			batch.end();
		}
	}

	public void pauseInGame() {
		TESTEVILMUSIC.setPosition(EvilMusicPosition);
		TESTEVILMUSIC.stop();
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//drawing the backdrop
		batch.draw(BackDrop, backGroundPosX, backGroundPosY + 80, 900 * BackScale, 1600 * BackScale);
		//This will stop the background grass animation, because I want the bird cage to break before the animation will start
		if (TimePassedDuringGame > 6)
			batch.draw(backTestAnimation.getKeyFrame(timePassed, true), backGroundPosX, backGroundPosY, 0, 0, 450, 800, animationScaleBack, animationScaleBack, 0);
		//else
		//batch.draw(backTestAnimation.getKeyFrame(1, true), backGroundPosX, backGroundPosY, 0, 0, 450, 800, animationScaleBack, animationScaleBack, 0);
		fireHealthRegion = new TextureRegion(fireHealthTexture, 0, 0, fireHealth,  439 + scoreScreenOffsetY);
		blueHealthRegion = new TextureRegion(blueHealthTexture, 0, 0, fireHealth,  439 + scoreScreenOffsetY);

		if (onFire && fireHealth <= 250) {
			flameHealth.setPosition(fireHealth - 30,  900 + scoreScreenOffsetY);
			flameHealth.draw(batch);
			batch.draw(fireHealthRegion , -31,  439 + scoreScreenOffsetY);

			// if the player is on fire and their fireHealth is decreasing
		} else if (onFire == false && fireHealth > 0) {
			waterHealth.setPosition(fireHealth - 30,  900 + scoreScreenOffsetY);
			waterHealth.draw(batch);
			batch.draw(blueHealthRegion, -31, 439 + scoreScreenOffsetY);
		}
		if (fireHealth > 0) {
			batch.draw(WaterTexture, 270, 925 - scoreScreenOffsetY);
		}
		else if (fireHealth == 0 && onFire) {
			batch.draw(OnFireTexture, 270, 925 - scoreScreenOffsetY);
		}
		//Drawing the score
		batch.draw(animation.getKeyFrame(timePassed, true), DoveTmpTouchX, DoveTmpTouchY, doveOriginOffsetX, doveOriginOffsetY, 835, 559, animationScale, animationScale, 0);

		//Drawing the brimstone
		for (int r = 0; r < numOfBrim; r++) {
			fireTrail[r].setPosition((int) brimeStoneXPos[r], (float) fallingSpeed[r] + h);
			fireTrail[r].draw(batch);
			batch.draw(animationBrimstone[r].getKeyFrame(timePassed, true), brimeStoneXPos[r] - 17, (float) fallingSpeed[r] + h, 0, 0, 520, 430, animationBrimStoneScale, animationBrimStoneScale, 0);
		}
		//Drawing the water
		for (int r = 0; r < numOfWater; r++) {
			waterTrail[r].setPosition((int) waterXPos[r], (float) waterFallingSpeed[r] + h);
			waterTrail[r].draw(batch);
		}
		for (int r = 0; r < numOfTime; r++) {
			WhitefireTrail[r].setPosition((int) timeXPos[r], (float) timeFallingSpeed[r] + h);
			WhitefireTrail[r].draw(batch);
		}
		batch.draw(fireTexture, -30, 940 - scoreScreenOffsetY);
		// if the user catches on fire
		if (onFire == true) {
			appleFire.setPosition(DoveTmpTouchX, DoveTmpTouchY);
			appleFire.draw(batch);
		}

		for (int i = 0; i < numOfBrim; i++)
			fireTrail[i].update(graphics.getDeltaTime());

		for (int i = 0; i < numOfWater; i++)
			waterTrail[i].update(graphics.getDeltaTime());

		for (int i = 0; i < numOfTime; i++)
			WhitefireTrail[i].update(graphics.getDeltaTime());

		appleFire.update(graphics.getDeltaTime());
		waterHeal.update(graphics.getDeltaTime());
		flameHealth.update(graphics.getDeltaTime());
		waterHealth.update(graphics.getDeltaTime());

		// if the player is on fire and their timer is still increasing
		if (onFire == true) {
			flameHealth.setPosition(fireHealth, 900 - scoreScreenOffsetY);
			flameHealth.draw(batch);
			batch.draw(fireHealthRegion, 100, 900 - scoreScreenOffsetY);
		}

		else if (onFire == false && fireHealth > 0) {
			// if the player is on fire and their fireHealth is decreasing
			waterHealth.setPosition(fireHealth, 900 - scoreScreenOffsetY);
			waterHealth.draw(batch);
			batch.draw(blueHealthRegion, 100, 900 - scoreScreenOffsetY);
		}

		// Drawing the regions of the health bars
		fireHealthRegion = new TextureRegion(fireHealthTexture, 0, 0, fireHealth, 0);
		blueHealthRegion = new TextureRegion(blueHealthTexture, 0, 0, fireHealth, 0);

		batch.draw(BlackTint,-200,-300);
		if (intScore != 8 && intScore != 88 && intScore != 888) {
			font.draw(batch, String.format("%s", StringScore), fontPosX - ScoreDisplacement, 850 - scoreScreenOffsetY);
		}
		else {
			font.draw(batch, String.format("%s", StringScore), fontPosX - ScoreDisplacement * 3/2 - 20, 860 - scoreScreenOffsetY);
		}
		batch.draw(PlayButtonTexture, 60, 280 - scoreScreenOffsetY);
		if (Gdx.input.justTouched() && touchX > 385 && touchX < 515 && touchY > 150 - scoreScreenOffsetY && touchY < 280 - scoreScreenOffsetY && SwitchSFX == true) {
			SwitchSFX = false;
			SwitchSound = false;
			prefs.putBoolean("SwitchSound", false);
			prefs.flush();
			prefs.putBoolean("SwitchSFX", false);
			prefs.flush();
		}
		else if (Gdx.input.justTouched() && touchX > 385 && touchX < 515 && touchY > 150 - scoreScreenOffsetY && touchY < 280 - scoreScreenOffsetY && SwitchSFX == false) {
			OkKeyPress.play(SFXVolume - keyPressOffset);
			SwitchSFX = true;
			SwitchSound = true;
			prefs.putBoolean("SwitchSound", true);
			prefs.flush();
			prefs.putBoolean("SwitchSFX", true);
			prefs.flush();
		}
		if (SwitchSFX == true)
			batch.draw(SoundOnBox, 275, 100 - scoreScreenOffsetY);
		else
			batch.draw(SoundOffBox, 275, 100 - scoreScreenOffsetY);
		batch.draw(HomeBox, -30, 100 - scoreScreenOffsetY);

		if (showAreYouSure) {
			batch.draw(BlackTint,-200,-300);
			batch.draw(AreYouSureTexture, 120, 550 - scoreScreenOffsetY);
			if (Gdx.input.justTouched() == true && touchX > 120 && touchX < 400 && touchY > 640 - scoreScreenOffsetY && touchY < 750 - scoreScreenOffsetY) {
				if (SwitchSFX)
					OkKeyPress.play(SFXVolume - keyPressOffset);
				showAreYouSure = false;
				introTime = 20.4f;
				showMainMenu = true;
				Pause = false;
				Score = 0;
				intScore = 0;
				scoreMovementIncrement = 10;
				timeCured = false;
				ScoreDisplacement = 0;
				onFire = false;
				waterCured = false;
				timePassed2 = 0;
				ChangeBackColour = false;
				TimePassedDuringGame = 0.0f;
				fireHealth = 0;
				EvilMusicPosition = 0.0f;
				count = 0;
				prefs.putBoolean("firstTime", false);
				prefs.flush();
				firstTime = false;
				showPrologue = false;
				reverseProject = false;
				timePassed2 = 0;
				brimIncrementTimer = 0;
				MusicVolume = 1.0f;
				tempScoreIncrease = 0;
				for (int i = 0; i < numOfBrim; i++) {
					fallingSpeed[i] = h;
					brimeStoneXPos[i] = (int) Math.round(Math.random() * 700 - 60);
					fallRate[i] = (Math.random() * 8 + 2);
				}
				for (int i = 0; i < numOfWater; i++) {
					waterFallingSpeed[i] = h;
					waterXPos[i] = (int) Math.round(Math.random() * 700 - 60);
					waterFallRate[i] = (Math.random() * 16 + 8);
				}
				for (int i = 0; i < numOfTime; i++) {
					timeFallingSpeed[i] = h;
					timeXPos[i] = (int) Math.round(Math.random() * 700 - 60);
					timeFallRate[i] = (Math.random() * 16 + 8);
				}
			}
			else if (Gdx.input.justTouched() == true && touchX > 120 && touchX < 450 && touchY > 520 - scoreScreenOffsetY && touchY < 640 - scoreScreenOffsetY) {
				if (SwitchSFX)
					ExitKeyPress.play(SFXVolume - keyPressOffset);
				showAreYouSure = false;
			}
		}
		if (Gdx.input.justTouched() && touchX > 80 && touchX < 210 && touchY > 150 - scoreScreenOffsetY && touchY < 280 - scoreScreenOffsetY) {
			if (SwitchSFX)
				OkKeyPress.play(SFXVolume - keyPressOffset);
			showAreYouSure = true;
		}
		batch.end();
	}

	@Override
	public void resume() {
		Pause = false;
	}
	Vector3 tp = new Vector3();
	boolean dragging;
	@Override public boolean mouseMoved (int screenX, int screenY) {
		// we can also handle mouse movement without anything pressed
//		camera.unproject(tp.set(screenX, screenY, 0));
		return false;
	}

	@Override public boolean touchDown (int screenX, int screenY, int pointer, int button) {
		// ignore if its not left mouse button or first touch pointer
		if (button != Input.Buttons.LEFT || pointer > 0) return false;
		camera.unproject(tp.set(screenX, screenY, 0));
		dragging = true;
		return true;
	}

	@Override public boolean touchDragged (int screenX, int screenY, int pointer) {
		if (!dragging) return false;
		camera.unproject(tp.set(screenX, screenY, 0));
		return true;
	}

	@Override public boolean touchUp (int screenX, int screenY, int pointer, int button) {
		if (button != Input.Buttons.LEFT || pointer > 0) return false;
		camera.unproject(tp.set(screenX, screenY, 0));
		dragging = false;
		return true;
	}

	@Override public boolean keyDown (int keycode) {
		return false;
	}

	@Override public boolean keyUp (int keycode) {
		return false;
	}

	@Override public boolean keyTyped (char character) {
		return false;
	}

	@Override public boolean scrolled (int amount) {
		return false;
	}

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 720;
		config.useHDPI = true;
		new LwjglApplication(new Ouroboros(), config);
	}
}
