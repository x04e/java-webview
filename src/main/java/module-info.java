module App {
    requires javafx.web;
	// Required for loading some external websites when built with jlink
	requires jdk.crypto.cryptoki;

    exports com.x04e;
}