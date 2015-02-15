package annotationsPkg;

public @interface NewAuthor {
	String authorName();
	String date();
	int currentRevision() default 1;
	
}
