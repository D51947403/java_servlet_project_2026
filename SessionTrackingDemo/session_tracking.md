# Session Tracking in Servlets
HTTP is a stateless protocol, which means the server does not remember the client after completing a request. Every request is treated as a completely new request.
Session tracking is a mechanism used to maintain the state of a user across multiple requests.

## Session Tracking Techniques
- 1. Cookies:
Cookies are small text files stored on the client browser. They contain user-related information and are sent back to the server with every request.
- 2. Hidden Form Field:
In this technique, hidden fields are added inside HTML forms using the <input type="hidden"> tag.
The hidden data travels from one page to another when the form is submitted. This technique works only with form submissions.
- 3. URL Rewriting:
URL rewriting appends session information directly to the URL. Example: http://localhost:8080/app/profile?sessionid=123
- 4. HttpSession:
HttpSession is the most commonly used session tracking technique in Servlets. It creates a session object on the server side to store user-specific data.
HttpSession provides better security and easier session management compared to other techniques.

### Reference
- https://www.tpointtech.com/session-tracking-in-servlets