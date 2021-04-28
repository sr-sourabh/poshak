FROM node:13.12.0-alpine

WORKDIR /poshak-ui

ENV PATH /poshak-ui/node_modules/.bin:$PATH

COPY poshak-ui/package.json ./
COPY poshak-ui/package-lock.json ./

COPY poshak-ui/ ./

CMD ["npm", "run", "start:prod"]
